import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from './login/login.component';
import {AccessDeniedComponent} from './access-denied/access-denied.component';
import {AuthGuard} from '../helpers/auth.guard';


const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'access-denied', component: AccessDeniedComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SecurityRoutingModule { }
