import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ImportRoutingModule } from './import-routing.module';
import { ImportManagerComponent } from './import-manager/import-manager.component';


@NgModule({
  declarations: [ImportManagerComponent],
  imports: [
    CommonModule,
    ImportRoutingModule
  ]
})
export class ImportModule { }
