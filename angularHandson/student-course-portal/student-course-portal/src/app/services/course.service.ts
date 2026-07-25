import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError, of } from 'rxjs';
import { map, catchError, tap, retry } from 'rxjs/operators';
import { Course } from '../models/course.model';

const API_URL = 'http://localhost:3000/courses';

// providedIn: 'root' makes this a singleton - one instance shared across the whole app,
// so CourseListComponent, HomeComponent, and any other consumer all read/write the same data.
@Injectable({ providedIn: 'root' })
export class CourseService {
  private http = inject(HttpClient);

  getCourses(): Observable<Course[]> {
    return this.http.get<Course[]>(API_URL).pipe(
      // tap is for side effects (logging) only - it must never mutate the stream.
      // Transformations belong in map, not tap.
      tap((courses) => console.log('Courses loaded:', courses.length)),
      map((courses) => courses.filter((c) => c.credits > 0)),
      retry(2), // retries the HTTP request up to 2 times before giving up
      catchError((err) => {
        console.error(err);
        return throwError(() => new Error('Failed to load courses. Please try again.'));
      })
    );
  }

  getCourseById(id: number): Observable<Course> {
    return this.http.get<Course>(`${API_URL}/${id}`).pipe(
      catchError((err) => {
        console.error(err);
        return throwError(() => new Error('Failed to load course details.'));
      })
    );
  }

  createCourse(course: Omit<Course, 'id'>): Observable<Course> {
    return this.http.post<Course>(API_URL, course);
  }

  updateCourse(course: Course): Observable<Course> {
    return this.http.put<Course>(`${API_URL}/${course.id}`, course);
  }

  deleteCourse(id: number): Observable<void> {
    return this.http.delete<void>(`${API_URL}/${id}`);
  }

  // Used with switchMap in CourseDetailComponent - simulated "enrolled students" lookup.
  getStudentsByCourse(courseId: number): Observable<string[]> {
    const mockRoster: Record<number, string[]> = {
      1: ['Aisha Khan', 'Rahul Verma'],
      2: ['Meera Nair'],
      3: ['Aisha Khan', 'Sara Ali', 'Devon Brooks'],
      4: [],
      5: ['Rahul Verma']
    };
    return of(mockRoster[courseId] ?? []);
  }
}
