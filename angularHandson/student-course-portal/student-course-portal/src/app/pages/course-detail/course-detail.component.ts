import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { Observable, of, switchMap } from 'rxjs';
import { Course } from '../../models/course.model';
import { CourseService } from '../../services/course.service';

@Component({
  selector: 'app-course-detail',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './course-detail.component.html',
  styleUrl: './course-detail.component.css'
})
export class CourseDetailComponent implements OnInit {
  private route = inject(ActivatedRoute);
  private courseService = inject(CourseService);

  course$!: Observable<Course>;
  // switchMap cancels the previous inner Observable (previous course's roster lookup)
  // whenever a new courseId arrives, preventing out-of-order responses if the user
  // navigates quickly between course detail pages.
  enrolledStudents$!: Observable<string[]>;

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.course$ = this.courseService.getCourseById(id);
    this.enrolledStudents$ = of(id).pipe(
      switchMap((courseId) => this.courseService.getStudentsByCourse(courseId))
    );
  }
}
