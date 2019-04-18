import { Routes } from '@angular/router';
import { AddPersonaComponent } from './components/add-persona/add-persona.component';
import { EditPersonaComponent } from './components/edit-persona/edit-persona.component';
import { ListPersonaComponent } from './components/list-persona/list-persona.component';

export const ROUTES: Routes = [
    { path: 'add-persona', component: AddPersonaComponent },
    { path: 'edit-persona', component: EditPersonaComponent },
    { path: 'list-persona', component: ListPersonaComponent },
    { path: '', pathMatch: 'full', redirectTo: 'list-persona' },
    { path: '**', pathMatch: 'full', redirectTo: 'list-persona' }
];
