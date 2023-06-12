import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SharedButtonComponent } from './shared/components/shared-button/shared-button.component';
import { SharedInputComponent } from './shared/components/shared-input/shared-input.component';
import { SharedProductCardComponent } from './shared/components/shared-product-card/shared-product-card.component';

@NgModule({
  declarations: [
    AppComponent,
    SharedButtonComponent,
    SharedInputComponent,
    SharedProductCardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
