import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { CourseListComponent } from './pages/course-list/course-list.component';
import { CourseDetailComponent } from './pages/course-detail/course-detail.component';
import { StudentProfileComponent } from './pages/student-profile/student-profile.component';
import { NotFoundComponent } from './pages/not-found/not-found.component';
import { authGuard } from './guards/auth.guard';

export const routes: Routes = [
  { path: '', component: HomeComponent },

  // Nested routes: /courses (list) and /courses/:id (detail) share a parent segment.
  {
    path: 'courses',
    children: [
      { path: '', component: CourseListComponent },
      { path: ':id', component: CourseDetailComponent }
    ]
  },

  // Route guarded by AuthGuard (Hands-On 7, Task 2)
  { path: 'profile', component: StudentProfileComponent, canActivate: [authGuard] },

  // Lazy-loaded feature module for enrollment forms (Hands-On 7, Task 2)
  {
    path: 'enroll',
    canActivate: [authGuard],
    loadChildren: () =>
      import('./features/enrollment/enrollment.routes').then((m) => m.ENROLLMENT_ROUTES)
  },

  // Wildcard route MUST be last - Angular matches routes in declaration order.
  { path: '**', component: NotFoundComponent }
];
