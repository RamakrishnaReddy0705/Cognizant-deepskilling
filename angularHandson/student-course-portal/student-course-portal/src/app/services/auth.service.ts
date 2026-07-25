import { Injectable } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class AuthService {
  // Hardcoded for the exercise - in a real app this would reflect a real login session.
  isLoggedIn = true;
}
