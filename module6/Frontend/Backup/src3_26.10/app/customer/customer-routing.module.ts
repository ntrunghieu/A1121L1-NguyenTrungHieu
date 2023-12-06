import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

import {CreateCustomerComponent} from './create-customer/create-customer.component';
import {ListCustomerComponent} from './list-customer/list-customer.component';
import {DetailCustomerComponent} from './detail-customer/detail-customer.component';

const routes: Routes = [
  {path: 'customer/list', component: ListCustomerComponent},
  {path: 'customer/detail/:id', component: DetailCustomerComponent},
  {
    path: 'customer/create', component: CreateCustomerComponent
  },
  {
    path: 'customer/edit/:id', component: CreateCustomerComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CustomerRoutingModule {
}
