import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {HomeComponent} from './home/home.component';
import {ErrorComponent} from './error/error.component';
import {ActivitiesComponent} from './activities/activities.component';


const routes: Routes = [{
  path: 'customer',
  loadChildren: () => import('./customer/customer.module').then(module => module.CustomerModule)
},
  {
    path: 'employee',
    loadChildren: () => import('./employee/employee.module').then(module => module.EmployeeModule)
  },
  {
    path: 'account',
    loadChildren: () => import('./account/account.module').then(module => module.AccountModule)
  },
  {
    path: 'import',
    loadChildren: () => import('./import/import.module').then(module => module.ImportModule)
  },
  {
    path: 'cart',
    loadChildren: () => import('./cart/cart.module').then(module => module.CartModule)
  },
  {
    path: 'material',
    loadChildren: () => import('./material/material.module').then(module => module.MaterialModule)
  },
  {
    path: 'auth',
    loadChildren: () => import('./security/security.module').then(module => module.SecurityModule)
  },
  {
    path: 'statistic',
    loadChildren: () => import('./statistic/statistic.module').then(module => module.StatisticModule)
  },
  {
    path: '', component: HomeComponent,
  },
  {
    path: 'error404', component: ErrorComponent
  },
  {
    path: 'activities', component: ActivitiesComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  declarations: []
})
export class AppRoutingModule {
}
