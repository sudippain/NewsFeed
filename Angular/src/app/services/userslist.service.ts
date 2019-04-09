import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserslistService {

  constructor(private http:HttpClient) { }

  changeUserStatus(userEmail):Observable<any>{
   
    return this.http.get("http://192.168.1.100:9090/NewsApp/user/changeStatus/"+userEmail);
    
  }

  AllUsersList():Observable<any>{
   
    return this.http.get("http://192.168.1.100:9090/NewsApp/common/admin/getAllUsers");
  }

  GetUser(userEmailSearch:String):Observable<any>{
    return this.http.get("http://192.168.1.100:9090/NewsApp/common/getSearchUsers/"+userEmailSearch);
  }

 
}
