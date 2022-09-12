import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {TodoAppComponent} from './todo-app/todo-app.component';


const routes: Routes = [
  {path: '', component: TodoAppComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
