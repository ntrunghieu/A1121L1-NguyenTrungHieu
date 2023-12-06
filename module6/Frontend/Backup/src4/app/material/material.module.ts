import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {MaterialRoutingModule} from './material-routing.module';
import {CreateMaterialComponent} from './create-material/create-material.component';
import {EditMaterialComponent} from './edit-material/edit-material.component';
import {DetailMaterialComponent} from './detail-material/detail-material.component';
import {ListMaterialComponent} from './list-material/list-material.component';
import {InforMaterialComponent} from './infor-material/infor-material.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import {HttpClientModule} from '@angular/common/http';
import {NotifierModule} from "angular-notifier";
import {NgxPaginationModule} from "ngx-pagination";

@NgModule({
  declarations: [CreateMaterialComponent, EditMaterialComponent, DetailMaterialComponent, ListMaterialComponent, InforMaterialComponent],
  exports: [
    InforMaterialComponent,
    DetailMaterialComponent,
    EditMaterialComponent,
    ListMaterialComponent
  ],
    imports: [
        CommonModule,
        ReactiveFormsModule,
        FormsModule,
        ReactiveFormsModule,
        RouterModule,
        NgbModule,
        MaterialRoutingModule, HttpClientModule,
        RouterModule, FormsModule, ReactiveFormsModule, NotifierModule, NgxPaginationModule

    ]})

export class MaterialModule { }
