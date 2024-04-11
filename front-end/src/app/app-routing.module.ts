import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TransacoesComponent } from './transacoes/transacoes.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  {path: 'transacoes', component: TransacoesComponent},
  {path: 'login', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
