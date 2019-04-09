import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsernewshistorydetailsService {

  constructor(private http:HttpClient) { }
  
  userNewsHistoryList(userEmail):Observable<any>{
    console.log("from history service"+userEmail);
    return this.http.get("http://192.168.1.100:9090/NewsApp/user/getUserHistory/"+userEmail);
  }

  newsHistoryDelete(id):Observable<any>{
    return this.http.delete("http://192.168.1.100:9090/NewsApp/user/deleteNewsHistory/"+id);
  }
}
