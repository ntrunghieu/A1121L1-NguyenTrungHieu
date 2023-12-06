import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { StatisticRoutingModule } from './statistic-routing.module';
import { MaterialStatisticComponent } from './material-statistic/material-statistic.component';
import { CustomerStatisticComponent } from './customer-statistic/customer-statistic.component';
import { FinancialStatisticComponent } from './financial-statistic/financial-statistic.component';


@NgModule({
  declarations: [MaterialStatisticComponent, CustomerStatisticComponent, FinancialStatisticComponent],
  imports: [
    CommonModule,
    StatisticRoutingModule
  ]
})
export class StatisticModule { }
