import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { User } from '../Model/user';

@Injectable({
  providedIn: 'root'
})
export class SignUpService {

  constructor(private http:HttpClient) { }

  usersignup(user:User){
    return this.http.post("http://192.168.1.100:9090/NewsApp/user/registerUser",user,{responseType:'text'});
  }
 
}
