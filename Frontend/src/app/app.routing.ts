import {Routes, RouterModule} from '@angular/router';

import {HomeComponent} from './components/home/home.component';
import {LoginComponent} from './components/login/login.component';
import {RegisterComponent} from './components/register/register.component';
import {AuthGuard} from './auth.guard';
import {UserPageComponent} from './pages/user-page/user-page.component';
import {LoginPageComponent} from './pages/login-page/login-page.component';

const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'login'},
  {path: 'login', component: LoginPageComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'home', component: HomeComponent, canActivate: [AuthGuard]},
  {path: 'user-page', component: UserPageComponent}
];

export const appRoutingModule = RouterModule.forRoot(routes);
