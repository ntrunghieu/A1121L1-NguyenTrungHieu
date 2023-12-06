import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MaterialRoutingModule } from './material-routing.module';
import { CreateMaterialComponent } from './create-material/create-material.component';
import { EditMaterialComponent } from './edit-material/edit-material.component';
import { DetailMaterialComponent } from './detail-material/detail-material.component';
import { ListMaterialComponent } from './list-material/list-material.component';
import { InforMaterialComponent } from './infor-material/infor-material.component';


@NgModule({
  declarations: [CreateMaterialComponent, EditMaterialComponent, DetailMaterialComponent, ListMaterialComponent, InforMaterialComponent],
  imports: [
    CommonModule,
    MaterialRoutingModule
  ]
})
export class MaterialModule { }
