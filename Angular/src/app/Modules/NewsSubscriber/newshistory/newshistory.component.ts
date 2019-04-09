import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { UsernewshistorydetailsService } from 'src/app/services/usernewshistorydetails.service';

@Component({
  selector: 'app-newshistory',
  templateUrl: './newshistory.component.html',
  styleUrls: ['./newshistory.component.css']
})
export class NewshistoryComponent implements OnInit {

  userHistoryList:any;
  constructor(private usernewshistory:UsernewshistorydetailsService,private router:Router) { }

  ngOnInit() {
    this.userNewsHistory();
  }

  public userNewsHistory(){
    this.usernewshistory.userNewsHistoryList(window.sessionStorage.getItem("userEmail")).subscribe( data=>{

     this.userHistoryList=data;
     console.log(this.userHistoryList);
    })

  }


  removeItem(id,search){
   
  
      var r=confirm("Want to delete "+search)
      if (r == true) {
        this.usernewshistory.newsHistoryDelete(id).subscribe(data =>{
          this.userNewsHistory();
        });
      } 
    
   
    // this.ngOnInit();
  
    
    
  }

  
  logout()
  {
	  window.sessionStorage.clear();
	  this.router.navigate(['Login']);

  }

}
