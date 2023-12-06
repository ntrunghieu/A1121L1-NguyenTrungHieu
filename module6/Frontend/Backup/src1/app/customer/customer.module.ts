import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {CustomerRoutingModule} from './customer-routing.module';

import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {ListCustomerComponent} from './component/list-customer/list-customer.component';
import {CreateCustomerComponent} from './component/create-customer/create-customer.component';
import {DetailCustomerComponent} from './component/detail-customer/detail-customer.component';


@NgModule({
  declarations: [CreateCustomerComponent, ListCustomerComponent, DetailCustomerComponent],
  exports: [
    DetailCustomerComponent,
    ListCustomerComponent,
    CreateCustomerComponent
  ],
  imports: [
    CommonModule,
    CustomerRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule
  ]
})
export class CustomerModule {
}
