# Student Course Portal — Digital Nurture 5.0 (Angular v20)

Complete solution project for all 10 Angular hands-on exercises. Every hands-on builds on the
same project (no separate projects per exercise), exactly as required by the exercise book.

## 1. Setup

```bash
npm install -g @angular/cli
npm install -g json-server
npm install
```

## 2. Running the app

Two things need to run together:

```bash
# Terminal 1 - mock REST API (courses/students/enrollments) used from Hands-On 8 onward
npm run mock-api          # -> json-server --watch db.json --port 3000

# Terminal 2 - the Angular dev server
npm start                 # -> ng serve, open http://localhost:4200
```

## 3. Running unit tests

```bash
npm test                  # ng test (Karma + Jasmine, watch mode)
ng test --code-coverage   # generates a report in coverage/
```

## 4. Where each Hands-On lives

| Hands-On | Topic | Key files |
|---|---|---|
| 1 | Setup, project structure, first component | `notes.txt`, `angular.json`, `components/header/*`, `pages/home/*` |
| 2 | Binding types, lifecycle hooks, @Input/@Output | `pages/home/home.component.ts`, `components/course-card/*` |
| 3 | Directives & pipes | `directives/highlight.directive.ts`, `pipes/credit-label.pipe.ts`, `pages/course-list/*` |
| 4 | Template-driven forms | `pages/enrollment-form/*` |
| 5 | Reactive forms, FormArray, custom/async validators | `pages/reactive-enrollment-form/*` |
| 6 | Services & DI | `services/course.service.ts`, `services/enrollment.service.ts` |
| 7 | Routing, guards, lazy loading | `app.routes.ts`, `features/enrollment/enrollment.routes.ts`, `guards/*` |
| 8 | HttpClient, RxJS operators, interceptors | `services/course.service.ts`, `interceptors/*` |
| 9 | NgRx store, actions, reducers, effects, selectors | `store/course/*`, `store/enrollment/*` |
| 10 | Unit testing | `components/course-card/course-card.component.spec.ts`, `services/course.service.spec.ts` |

## 5. App routes

- `/` — Home / Dashboard
- `/courses` — Course listing (search via `?search=`)
- `/courses/:id` — Course detail (route param + switchMap roster lookup)
- `/profile` — Student profile (guarded by `authGuard`)
- `/enroll` — Template-driven enrollment form (lazy-loaded)
- `/enroll/reactive` — Reactive enrollment form (lazy-loaded, `CanDeactivate` guarded)
- `**` — 404 Not Found page

## 6. Notes

- All components are **standalone** (Angular 20 default) — there is no `app.module.ts`;
  see `app.config.ts` / `app.routes.ts` instead.
- Redux DevTools browser extension will show the full NgRx action → effect → reducer flow
  once you install it and open DevTools while the app is running.
- `db.json` seeds 5 courses so the course list, detail, and enrollment flows all work
  out of the box against `json-server`.
