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
    CustomerDetailComponent,
    CustomerCreateComponent,
    CustomerUpdateComponent,
    ContractListComponent,
    ContractCreateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
