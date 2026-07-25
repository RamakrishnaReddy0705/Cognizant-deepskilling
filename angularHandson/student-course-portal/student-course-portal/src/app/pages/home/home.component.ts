import { Component, OnDestroy, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { loadCourses } from '../../store/course/course.actions';
import { selectAllCourses } from '../../store/course/course.selectors';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit, OnDestroy {
  private store = inject(Store);

  // String interpolation target
  portalName = 'Student Course Portal';

  // Property binding target
  isPortalActive = true;

  // Event binding + message state
  message = '';

  // Two-way binding target
  searchTerm = '';

  enrolledCount = 3;
  gpa = 3.8;

  coursesAvailable$: Observable<number> = this.store.select(selectAllCourses).pipe(map((c) => c.length));

  ngOnInit(): void {
    this.store.dispatch(loadCourses());
    console.log('HomeComponent initialised - courses loaded');
  }

  ngOnDestroy(): void {
    console.log('HomeComponent destroyed');
  }

  onEnrollClick(): void {
    this.message = 'Enrollment opened!';
  }

  // Difference: [property] is one-way (component -> DOM only).
  // [(ngModel)] is two-way - it is shorthand for [ngModel]="prop" (ngModelChange)="prop = $event",
  // meaning changes made by the user in the DOM flow back into the component property too.
}
