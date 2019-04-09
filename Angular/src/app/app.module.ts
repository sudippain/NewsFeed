import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SignUpComponent } from './Modules/NewsSubscriber/sign-up/sign-up.component';
import { LoginComponent } from './Modules/NewsSubscriber/login/login.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { LoginService } from './services/login.service';
import { SignUpService } from './services/sign-up.service';
import { NewsComponent } from './Modules/NewsSubscriber/news/news.component';
import { NewsService } from './services/news.service';
import { httpInterceptorProviders } from './auth-intercepter';
import { UserDetailsComponent } from './Modules/NewsSubscriber/user-details/user-details.component';

import { UsersListComponent } from './Modules/Admin/users-list/users-list.component';
import { NewshistoryComponent } from './Modules/NewsSubscriber/newshistory/newshistory.component';
import {NgxPaginationModule} from 'ngx-pagination'; 




@NgModule({
  declarations: [
    AppComponent,
    SignUpComponent,
    LoginComponent,
    NewsComponent,
    UserDetailsComponent,
    UsersListComponent,
    NewshistoryComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgxPaginationModule,
    
  ],
  providers: [LoginService,SignUpService,NewsService,httpInterceptorProviders
      

],
  bootstrap: [AppComponent]
})
export class AppModule { }
