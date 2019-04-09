import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NewsService } from 'src/app/services/news.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UserHistory } from 'src/app/Model/user-history';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})
export class NewsComponent implements OnInit {

  mArticles:Array<any>;
  mSources:Array<any>;
  userSearchForm:FormGroup;
  constructor(private router:Router,private newsservice:NewsService,private formbuilder:FormBuilder) { }

  ngOnInit() {
     //load articles
     this.newsservice.initArticles().subscribe(data => this.mArticles = data['articles']);
     //load news sources
     this.newsservice.initSources().subscribe(data=> this.mSources = data['sources']);  
     this.userSearchForm=this.formbuilder.group({
      userNewsSearch:['',[Validators.required]]
     });
     
     
    
  }
 
onSearch(userSearch:UserHistory):void{

  userSearch.userEmail=window.sessionStorage.getItem("userEmail");

   console.log(userSearch);
   console.log(userSearch.userEmail);
   console.log(userSearch.userNewsSearch);

  this.newsservice.userNewsSearch(userSearch.userNewsSearch).subscribe(data =>
    { 
      if(data['totalResults']==0){
        alert("Invalid Request");
        this.userSearchForm.reset();
      }
      else{
      this.mArticles = data['articles'];
    }
    });
  

   
    this.newsservice.userSearchHistory(userSearch);
  
  
   
}
  

  logout()
  {
	  window.sessionStorage.clear();
	  this.router.navigate(['Login']);

  }
  

}
