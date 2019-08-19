import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddPropostaComponent } from './components/add-proposta/add-proposta.component';
import { SearchPropostaComponent } from './components/search-proposta/search-proposta.component';


const routes: Routes = [
  { path: '', redirectTo: 'search-proposta', pathMatch: 'full' },
  { path: 'search-proposta', component: SearchPropostaComponent },
  { path: 'add-proposta', component: AddPropostaComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
