import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CustomerCreateComponent} from './customer-all/customer-create/customer-create.component';
import {CustomerComponent} from './customer-all/customer/customer.component';
import {CustomerDetailComponent} from './customer-all/customer-detail/customer-detail.component';
import {CustomerUpdateComponent} from './customer-all/customer-update/customer-update.component';


const routes: Routes = [
  {path: 'create', component: CustomerCreateComponent},
  {path: '', component: CustomerComponent},
  {path: 'detail/:id', component: CustomerDetailComponent},
  {path: 'update', component: CustomerUpdateComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
