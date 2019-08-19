import { PropostasService } from './service/PropostasService';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { TableModule } from 'primeng/table';
import { PanelModule } from 'primeng/panel';
import { ScrollPanelModule } from 'primeng/scrollpanel';
import { InputTextareaModule } from 'primeng/inputtextarea';
import { CheckboxModule } from 'primeng/checkbox';
import { ButtonModule } from 'primeng/button';
import { AccordionModule } from 'primeng/accordion';
import { FileUploadModule } from 'primeng/fileupload';
import { DropdownModule } from 'primeng/dropdown';
import { DialogModule } from 'primeng/dialog';
import { MessagesModule } from 'primeng/messages';
import { MessageModule } from 'primeng/message';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { KeyFilterModule } from 'primeng/keyfilter';

import { AddPropostaComponent } from './components/add-proposta/add-proposta.component';
import { SearchPropostaComponent } from './components/search-proposta/search-proposta.component';

@NgModule({
  declarations: [
    AppComponent,
    AddPropostaComponent,
    SearchPropostaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule, TableModule, PanelModule, ScrollPanelModule, AccordionModule,
    InputTextareaModule, CheckboxModule, ButtonModule, FileUploadModule,
    DropdownModule, DialogModule, MessagesModule, MessageModule, FormsModule, ReactiveFormsModule,
    BrowserAnimationsModule,KeyFilterModule
  ],
  providers: [PropostasService],
  bootstrap: [AppComponent]
})
export class AppModule { }
