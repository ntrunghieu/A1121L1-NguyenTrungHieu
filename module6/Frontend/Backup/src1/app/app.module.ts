import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {CustomerModule} from './customer/customer.module';
import {EmployeeModule} from './employee/employee.module';
import {CartModule} from './cart/cart.module';
import {AccountModule} from './account/account.module';
import {SecurityModule} from './security/security.module';
import {MaterialModule} from './material/material.module';
import { HeaderComponent } from './header/header.component';
import { ErrorComponent } from './error/error.component';
import {ReactiveFormsModule} from '@angular/forms';


import {AngularFireModule} from '@angular/fire';
import {environment} from '../environments/environment';
import {AngularFireStorageModule} from '@angular/fire/storage';
import {AngularFireDatabaseModule} from '@angular/fire/database';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ErrorComponent
  ],
  imports: [
    AngularFireModule.initializeApp(environment.firebaseConfig),
    AngularFireStorageModule,
    AngularFireDatabaseModule,
    BrowserModule,
    AppRoutingModule,
    CustomerModule,
    EmployeeModule,
    CartModule,
    AccountModule,
    SecurityModule,
    MaterialModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
