import { Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Course } from '../../models/course.model';
import { CreditLabelPipe } from '../../pipes/credit-label.pipe';
import { HighlightDirective } from '../../directives/highlight.directive';
import { selectEnrolledIds } from '../../store/enrollment/enrollment.selectors';
import { enrollInCourse, unenrollFromCourse } from '../../store/enrollment/enrollment.actions';

@Component({
  selector: 'app-course-card',
  standalone: true,
  imports: [CommonModule, CreditLabelPipe, HighlightDirective],
  templateUrl: './course-card.component.html',
  styleUrl: './course-card.component.css'
})
export class CourseCardComponent implements OnInit, OnChanges {
  @Input() course!: Course;
  @Output() enrollRequested = new EventEmitter<number>();

  private store = inject(Store);

  isExpanded = false;
  isEnrolled$!: Observable<boolean>;

  ngOnInit(): void {
    this.isEnrolled$ = this.store
      .select(selectEnrolledIds)
      .pipe(map((ids) => ids.includes(this.course.id)));
  }

  // Fires whenever an @Input property changes; logs previous vs current course value.
  ngOnChanges(changes: SimpleChanges): void {
    if (changes['course']) {
      console.log(
        'Course changed - previous:',
        changes['course'].previousValue,
        'current:',
        changes['course'].currentValue
      );
    }
  }

  // Getter keeps the template clean instead of an inline ngClass object literal.
  get cardClasses(): Record<string, boolean> {
    return {
      'card--enrolled': false, // set reactively via isEnrolled$ in the template
      'card--full': this.course.credits >= 4,
      expanded: this.isExpanded
    };
  }

  get borderColor(): string {
    switch (this.course.gradeStatus) {
      case 'passed':
        return 'green';
      case 'failed':
        return 'red';
      default:
        return 'grey';
    }
  }

  toggleExpanded(): void {
    this.isExpanded = !this.isExpanded;
  }

  onEnrollClick(): void {
    this.enrollRequested.emit(this.course.id);
    this.store.dispatch(enrollInCourse({ courseId: this.course.id }));
  }

  onUnenrollClick(): void {
    this.store.dispatch(unenrollFromCourse({ courseId: this.course.id }));
  }
}
