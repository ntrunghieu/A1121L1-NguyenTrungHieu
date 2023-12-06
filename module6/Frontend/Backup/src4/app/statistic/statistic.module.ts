import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {StatisticRoutingModule} from './statistic-routing.module';
import {MaterialStatisticComponent} from './material-statistic/material-statistic.component';
import {CustomerStatisticComponent} from './customer-statistic/customer-statistic.component';
import {FinancialStatisticComponent} from './financial-statistic/financial-statistic.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NgxPaginationModule} from 'ngx-pagination';
import {HttpClientModule} from '@angular/common/http';


@NgModule({
  declarations: [MaterialStatisticComponent, CustomerStatisticComponent, FinancialStatisticComponent],
  exports: [
    MaterialStatisticComponent,
    FinancialStatisticComponent,
    CustomerStatisticComponent
  ],
  imports: [
    CommonModule,
    StatisticRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    NgxPaginationModule,
    HttpClientModule
  ]
})
export class StatisticModule {
}
