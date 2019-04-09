import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserHistory } from '../Model/user-history';

@Injectable({
  providedIn: 'root'
})
export class NewsService {

  api_key="1a045b6b558941a3b88ce98a276fe47b";
  constructor(private http:HttpClient) { }
  initSources(){
    return this.http.get('https://newsapi.org/v2/sources?language=en&apiKey='+this.api_key);
 }
 initArticles(){
  return this.http.get('https://newsapi.org/v2/top-headlines?sources=abc-news&pageSize=5&language=en&apiKey='+this.api_key);
 }  

 userNewsSearch(userSearch:String){

  
  return this.http.get('https://newsapi.org/v2/everything?q='+userSearch+'&apiKey='+this.api_key);
 }
userSearchHistory(userHistory:UserHistory):void{
  console.log("Inside calling");
 this.http.post("http://localhost:8085/user/userSearchNews",userHistory).subscribe();
}
}
