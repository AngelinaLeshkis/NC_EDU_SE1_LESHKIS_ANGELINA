import {Routes, RouterModule} from '@angular/router';

import {HomeComponent} from './components/home/home.component';
import {RegisterComponent} from './components/register/register.component';
import {AuthGuard} from './auth.guard';
import {UserPageComponent} from './pages/user-page/user-page.component';
import {LoginPageComponent} from './pages/login-page/login-page.component';
import {EditPageComponent} from './pages/edit-page/edit-page.component';
import {AddPostComponent} from './components/add-post/add-post.component';
import {PostComponent} from './components/post/post.component';
import {PostViewComponent} from './components/post-view/post-view.component';

const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'login'},
  {path: 'login', component: LoginPageComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'home', component: HomeComponent, canActivate: [AuthGuard]},
  {path: 'user-page', component: UserPageComponent},
  {path: 'edit-page', component: EditPageComponent},
  {path: 'addPost-page', component: AddPostComponent},
  {path: 'post-view', component: PostViewComponent}
];

export const appRoutingModule = RouterModule.forRoot(routes);
