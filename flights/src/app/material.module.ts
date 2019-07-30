import { NgModule } from '@angular/core';
import {
  MatDatepickerModule,
  MatNativeDateModule
} from '@angular/material';

const Material = [
  MatDatepickerModule,
  MatNativeDateModule
];

@NgModule({
  imports: [Material],
  exports: [Material]
})
export class MaterialModule {}