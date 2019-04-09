import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserdetailsService {

  constructor(private httpClient:HttpClient) { }

  userDetails(userEmail):Observable<any>{
    return this.httpClient.get("http://192.168.1.100:9090/NewsApp/user/getUserDetails/"+userEmail);
  }

}
