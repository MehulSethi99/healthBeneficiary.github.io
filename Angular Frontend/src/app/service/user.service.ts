import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../model/user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  baseURL = 'http://localhost:5433/Users';
  constructor(private http: HttpClient) { }
  saveUser(user: User) :Observable<any>{
    console.log(user);
    return this.http.post(this.baseURL, user);
  }
}
