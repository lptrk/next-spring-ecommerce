import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SharedButtonComponent } from './shared/components/shared-button/shared-button.component';
import { SharedInputComponent } from './shared/components/shared-input/shared-input.component';
import { SharedProductCardComponent } from './shared/components/shared-product-card/shared-product-card.component';
import { SharedTurnBackComponent } from './shared/components/shared-turn-back/shared-turn-back.component';
import { RegisterComponent } from './feat/pages/register/register.component';

@NgModule({
  declarations: [
    AppComponent,
    SharedButtonComponent,
    SharedInputComponent,
    SharedProductCardComponent,
    SharedTurnBackComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
