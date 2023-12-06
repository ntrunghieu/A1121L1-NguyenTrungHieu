import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {EmployeeRoutingModule} from './employee-routing.module';
import {EditEmployeeComponent} from './edit-employee/edit-employee.component';
import {ListEmployeeComponent} from './list-employee/list-employee.component';
import {CreateEmployeeComponent} from './create-employee/create-employee.component';
import {DetailEmployeeComponent} from './detail-employee/detail-employee.component';
import {AdminEditEmployeeComponent} from './admin-edit-employee/admin-edit-employee.component';
import {FormsModule , ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {AccountModule} from '../account/account.module';
import {NgbTooltipModule} from '@ng-bootstrap/ng-bootstrap';
import {RouterModule} from '@angular/router';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {NgxPaginationModule} from "ngx-pagination";
import {NotifierModule} from "angular-notifier";


@NgModule({
  // tslint:disable-next-line:max-line-length
  declarations: [EditEmployeeComponent, ListEmployeeComponent, CreateEmployeeComponent, DetailEmployeeComponent, AdminEditEmployeeComponent],
  exports: [
    DetailEmployeeComponent,
    ListEmployeeComponent,
    CreateEmployeeComponent,
    AdminEditEmployeeComponent,
    EditEmployeeComponent
  ],
    imports: [
        CommonModule,
        EmployeeRoutingModule,
        FormsModule,
        NgbModule,
        RouterModule,
        HttpClientModule,
        ReactiveFormsModule,
        AccountModule,
        NgbTooltipModule,
        NgxPaginationModule,
        NotifierModule
    ]
})
export class EmployeeModule {
}
