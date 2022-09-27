
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomerComponent } from './customer-all/customer/customer.component';
import { HeaderComponent } from './header/header.component';
import { HeadComponent } from './head/head.component';
import { FooterComponent } from './footer/footer.component';
import { NavigationComponent } from './navigation/navigation.component';
import { ServiceListComponent } from './service-list/service-list.component';
import { ServiceCreateComponent } from './service-create/service-create.component';
import { ServiceUpdateComponent } from './service-update/service-update.component';
import { CustomerDetailComponent } from './customer-all/customer-detail/customer-detail.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';


import { CustomerCreateComponent } from './customer-all/customer-create/customer-create.component';
import { CustomerUpdateComponent } from './customer-all/customer-update/customer-update.component';
import { ContractListComponent } from './contract-all/contract-list/contract-list.component';
import { ContractCreateComponent } from './contract-all/contract-create/contract-create.component';
import { EmployeeListComponent } from './employee/employee-list/employee-list.component';


import { EmployeeCreateComponent } from './employee/employee-create/employee-create.component';
import { EmployeeUpdateComponent } from './employee/employee-update/employee-update.component';
import { EmployeeDetailComponent } from './employee/employee-detail/employee-detail.component';
import {HttpClientModule} from '@angular/common/http';
import {NgxPaginationModule} from 'ngx-pagination';
import {Ng2SearchPipeModule} from 'ng2-search-filter';
import { NgxScrollTopModule } from 'ngx-scrolltop';
import {OrderModule} from 'ngx-order-pipe';
import { ContractDetailComponent } from './contract-all/contract-detail/contract-detail.component';
import { CarouselsComponent } from './carousels/carousels.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';





@NgModule({
  declarations: [
    AppComponent,
    CustomerComponent,
    HeaderComponent,
    HeadComponent,
    FooterComponent,
    NavigationComponent,
    ServiceListComponent,
    ServiceCreateComponent,
    ServiceUpdateComponent,
    CustomerComponent,
    CustomerDetailComponent,
    CustomerCreateComponent,
    CustomerUpdateComponent,
    ContractListComponent,
    ContractCreateComponent,
    EmployeeListComponent,
    EmployeeCreateComponent,
    EmployeeUpdateComponent,
    EmployeeDetailComponent,
    ContractDetailComponent,
    CarouselsComponent
  ],
  imports: [
    BrowserAnimationsModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgxPaginationModule, Ng2SearchPipeModule, NgxScrollTopModule, OrderModule

    // BrowserAnimationsModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
