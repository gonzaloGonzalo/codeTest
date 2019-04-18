import { Component, OnInit } from '@angular/core';
import { Persona } from '../../model/persona';
import { PersonaService } from '../../services/persona.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-persona',
  templateUrl: './list-persona.component.html',
  styles: []
})
export class ListPersonaComponent implements OnInit {
  persona: Persona[];

  constructor(private router: Router, private service: PersonaService) {}

  ngOnInit() {
    this.service.getPersonas().subscribe(data => (this.persona = data));
  }

  deletePersona(persona: Persona): void {
  }

  editPersona(persona: Persona): void {
    localStorage.removeItem('editPersonaId');
    localStorage.setItem('editPersonaId', persona.id.toString());
    this.router.navigate(['edit-persona']);
  }

  addPersona(): void {
    this.router.navigate(['add-persona']);
  }
}
