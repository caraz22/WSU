import { NgModule } from '@angular/core';
import { NavbarComponent } from './navbar/navbar.component';
import { ModalComponent } from './modal/modal.component';
import { CommonModule } from '@angular/common';
import { RouterModule } from "@angular/router";

@NgModule({ // shared module to avoid repetitive imports at component level, without also importing everything in appModule
  declarations: [
  ],
  imports: [
    CommonModule,
    RouterModule,
    NavbarComponent,
    ModalComponent
  ],
  exports: [CommonModule, RouterModule]
})
export class SharedModule { }
