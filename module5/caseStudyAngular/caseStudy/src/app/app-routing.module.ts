import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CustomerCreateComponent} from './customer-all/customer-create/customer-create.component';
import {CustomerComponent} from './customer-all/customer/customer.component';
import {CustomerDetailComponent} from './customer-all/customer-detail/customer-detail.component';
import {CustomerUpdateComponent} from './customer-all/customer-update/customer-update.component';
import {EmployeeListComponent} from './employee/employee-list/employee-list.component';
import {EmployeeCreateComponent} from './employee/employee-create/employee-create.component';
import {EmployeeDetailComponent} from './employee/employee-detail/employee-detail.component';
import {EmployeeUpdateComponent} from './employee/employee-update/employee-update.component';
import {ServiceListComponent} from './service-list/service-list.component';
import {ContractListComponent} from './contract-all/contract-list/contract-list.component';
import {ContractCreateComponent} from './contract-all/contract-create/contract-create.component';


const routes: Routes = [
  // {path: '', pathMatch: 'full', redirectTo: 'service-list'},
  {path: '', component: ServiceListComponent},
  {path: 'customer/create', component: CustomerCreateComponent},
  {path: 'customer', component: CustomerComponent},
  {path: 'customer/detail/:id', component: CustomerDetailComponent},
  {path: 'customer/update/:id', component: CustomerUpdateComponent},
  {path: 'employee', component: EmployeeListComponent},
  {path: 'employee/create', component: EmployeeCreateComponent},
  {path: 'employee/detail/:id', component: EmployeeDetailComponent},
  {path: 'employee/update/:id', component: EmployeeUpdateComponent},
  {path: 'contract', component: ContractListComponent},
  {path: 'contract/create', component: ContractCreateComponent}



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
