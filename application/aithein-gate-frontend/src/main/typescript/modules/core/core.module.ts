/*
 * core.module.ts
 *
 * Copyright (C) 2017 [ A Legge Up ]
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LoggerService } from './services/logger.service';
import { NavComponent } from './nav/nav.component';
import { NavBrandComponent } from './nav/brand/brand.component';

@NgModule({
  declarations: [
    NavComponent,
    NavBrandComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    NavComponent,
    NavBrandComponent
  ],
  providers: [
    LoggerService
  ]
})

export class CoreModule {
}
