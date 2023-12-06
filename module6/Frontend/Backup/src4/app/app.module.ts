import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {CustomerModule} from './customer/customer.module';
import {EmployeeModule} from './employee/employee.module';
import {CartModule} from './cart/cart.module';
import {AccountModule} from './account/account.module';
import {SecurityModule} from './security/security.module';
import {MaterialModule} from './material/material.module';

import {AngularFireModule} from '@angular/fire';
import {environment} from '../environments/environment';
import {AngularFireStorageModule} from '@angular/fire/storage';
import {AngularFireDatabaseModule} from '@angular/fire/database';
import {StatisticModule} from './statistic/statistic.module';
import {HeaderComponent} from './header/header.component';
import {ErrorComponent} from './error/error.component';
import {ReactiveFormsModule} from '@angular/forms';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {HomeComponent} from './home/home.component';
import {HttpClientModule} from '@angular/common/http';
import {RouterModule} from '@angular/router';
import {authInterceptorProviders} from './helpers/auth.interceptor';
import {JWT_OPTIONS, JwtHelperService} from '@auth0/angular-jwt';
import {APP_BASE_HREF} from '@angular/common';
import {NotifierModule} from 'angular-notifier';
import {LoadingBarRouterModule} from '@ngx-loading-bar/router';
import { ActivitiesComponent } from './activities/activities.component';
import {NgxPaginationModule} from 'ngx-pagination';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ErrorComponent,
    HomeComponent,
    ActivitiesComponent
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
    ReactiveFormsModule,
    AngularFireModule.initializeApp(environment.firebaseConfig),
    NgbModule,
    StatisticModule,
    HttpClientModule,
    RouterModule,
    NotifierModule,
    LoadingBarRouterModule, NgxPaginationModule
  ],
  providers: [ authInterceptorProviders,
    JwtHelperService,
    {provide: JWT_OPTIONS, useValue: JWT_OPTIONS},
    { provide: APP_BASE_HREF, useValue: '/'}
    ],
  bootstrap: [AppComponent]
})
export class AppModule { }
