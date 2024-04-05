import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ValoresComponent } from './valores/valores.component';
import { AlternadorComponent } from './alternador/alternador.component';


@NgModule({
  declarations: [
    AppComponent,
    ValoresComponent,
    AlternadorComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
