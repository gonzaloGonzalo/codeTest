import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';

import { HttpClientModule } from '@angular/common/http';
import { AddPersonaComponent } from './components/add-persona/add-persona.component';
import { EditPersonaComponent } from './components/edit-persona/edit-persona.component';
import { ListPersonaComponent } from './components/list-persona/list-persona.component';

// Importar rutas
import { ROUTES } from './app.routes';
import { RouterModule } from '@angular/router';

// Importar ReactiveFormsModule para los formularios
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    AddPersonaComponent,
    EditPersonaComponent,
    ListPersonaComponent
  ],
  imports: [
      BrowserModule,
      HttpClientModule,
      RouterModule.forRoot( ROUTES, { useHash: true } ),
      ReactiveFormsModule
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule { }
