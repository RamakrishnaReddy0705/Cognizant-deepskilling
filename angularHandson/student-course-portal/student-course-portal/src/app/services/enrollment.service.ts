import { Injectable, inject } from '@angular/core';
import { CourseService } from './course.service';
import { Course } from '../models/course.model';

// Demonstrates service-to-service injection: EnrollmentService depends on CourseService
// to resolve enrolled course IDs into full Course objects.
@Injectable({ providedIn: 'root' })
export class EnrollmentService {
  private courseService = inject(CourseService);
  private enrolledCourseIds: number[] = [];

  enroll(courseId: number): void {
    if (!this.isEnrolled(courseId)) {
      this.enrolledCourseIds.push(courseId);
    }
  }

  unenroll(courseId: number): void {
    this.enrolledCourseIds = this.enrolledCourseIds.filter((id) => id !== courseId);
  }

  isEnrolled(courseId: number): boolean {
    return this.enrolledCourseIds.includes(courseId);
  }

  getEnrolledCourses(): Course[] {
    // NOTE: in a real app this would map IDs -> Course objects via CourseService state.
    // Kept simple here since course data now lives in the NgRx store (see Hands-On 9).
    return [];
  }
}
