import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ValoresComponent } from './valores/valores.component';
import { AlternadorComponent } from './alternador/alternador.component';
import { TabelaComponent } from './tabela/tabela.component';
import { TransacoesComponent } from './transacoes/transacoes.component';
import { LoginComponent } from './login/login.component';


@NgModule({
  declarations: [
    AppComponent,
    ValoresComponent,
    AlternadorComponent,
    TabelaComponent,
    TransacoesComponent,
    LoginComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
