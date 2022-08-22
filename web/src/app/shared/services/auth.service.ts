import { Injectable } from '@angular/core';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  user: User;
  constructor() {
    this.user =  {
      uid: "ffff",
      displayName: "Raul Alzate",
      photoURL: "",
      emailVerified: false,
      email: "email@gmail.com"
    };
   }
}
