import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {FinancialStatisticComponent} from './financial-statistic/financial-statistic.component';
import {MaterialStatisticComponent} from './material-statistic/material-statistic.component';
import {CustomerStatisticComponent} from './customer-statistic/customer-statistic.component';


const routes: Routes = [
  {
    path: 'statistic/material', component: MaterialStatisticComponent
  },
  {
    path: 'statistic/financial', component: FinancialStatisticComponent
  },
  {
    path: 'statistic/customer', component: CustomerStatisticComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class StatisticRoutingModule { }
