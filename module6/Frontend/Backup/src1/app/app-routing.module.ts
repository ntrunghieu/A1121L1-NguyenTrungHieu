import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';


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
    path: 'security',
    loadChildren: () => import('./security/security.module').then(module => module.SecurityModule)
  },
  {
    path: 'statistic',
    loadChildren: () => import('./statistic/statistic.module').then(module => module.StatisticModule)
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  declarations: []
})
export class AppRoutingModule {
}
