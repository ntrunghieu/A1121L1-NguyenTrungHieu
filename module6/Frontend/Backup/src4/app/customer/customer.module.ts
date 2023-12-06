import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {CustomerRoutingModule} from './customer-routing.module';

import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {ListCustomerComponent} from './list-customer/list-customer.component';
import {CreateCustomerComponent} from './create-customer/create-customer.component';
import {DetailCustomerComponent} from './detail-customer/detail-customer.component';
import {NotifierModule} from 'angular-notifier';
import {NgxPaginationModule} from 'ngx-pagination';


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
        HttpClientModule,
        NotifierModule,
        NgxPaginationModule
    ]
})
export class CustomerModule {
}
