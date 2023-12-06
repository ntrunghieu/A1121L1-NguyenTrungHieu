import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {ImportRoutingModule} from './import-routing.module';
import {ImportManagerComponent} from './import-manager/import-manager.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {ImportMaterialFormComponent} from './import-manager/import-material-form/import-material-form.component';
import {ImportMaterialCustomerFormComponent} from './import-manager/import-material-customer-form/import-material-customer-form.component';
import {NotifierModule} from 'angular-notifier';
import {NgxPaginationModule} from 'ngx-pagination';


@NgModule({
  declarations: [ImportManagerComponent, ImportMaterialFormComponent, ImportMaterialCustomerFormComponent],
  exports: [
    ImportManagerComponent
  ],
  imports: [
    CommonModule,
    ImportRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    NotifierModule,
    NgxPaginationModule
  ]
})
export class ImportModule {
}
