import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SignUpComponent } from './Modules/NewsSubscriber/sign-up/sign-up.component';
import { LoginComponent } from './Modules/NewsSubscriber/login/login.component';
import { NewsComponent } from './Modules/NewsSubscriber/news/news.component';
import { AuthGuardGuard } from './AuthGuard/auth-guard.guard';
import { UserDetailsComponent } from './Modules/NewsSubscriber/user-details/user-details.component';

import { UsersListComponent } from './Modules/Admin/users-list/users-list.component';
import { NewshistoryComponent } from './Modules/NewsSubscriber/newshistory/newshistory.component';






const routes: Routes = [
  {
  path : 'Signup',
  component : SignUpComponent
  },
  {
   path : 'Login',
   component : LoginComponent
  },
  {
    path : 'News',
    component: NewsComponent,
    canActivate : [AuthGuardGuard]
  },
  {
    path : 'UserDetails',
    component : UserDetailsComponent,
    canActivate : [AuthGuardGuard]
  },

  {
    path  : 'UsersList',
    component : UsersListComponent,
    canActivate : [AuthGuardGuard]

  },
  {
    path : 'UserNewsHistory',
    component : NewshistoryComponent,
    canActivate : [AuthGuardGuard]
  }
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
