import { Component, OnInit } from '@angular/core';
import { Persona } from '../../model/persona';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { PersonaService } from '../../services/persona.service';
import { Router } from '@angular/router';
import {first} from 'rxjs/operators';

@Component({
  selector: 'app-edit-persona',
  templateUrl: './edit-persona.component.html',
  styles: []
})
export class EditPersonaComponent implements OnInit {

  customer: Persona;
  editForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private router: Router, private service: PersonaService) { }

  ngOnInit() {

    const personaId = localStorage.getItem('editPersonaId');

    if ( !personaId ) {
      alert('Acción invalida');
      this.router.navigate(['list-persona']);
      return;
    }

    this.editForm = this.formBuilder.group({
      id: [],
      nombre: ['', Validators.required],
      apellido: ['', Validators.required],
      fechaNacimiento: ['', Validators.required],
      tipoDocumento: ['', Validators.required],
      numeroDocumento: ['', Validators.required]
    });

    this.service.getPersona(+personaId)
      .subscribe(data => {
        this.editForm.setValue(data);
      });
  }

  onSubmit() {
    this.service.updatePersona(this.editForm.value)
      .pipe(first())
      .subscribe( data => {
        this.router.navigate(['list-persona']);
      },
      error => {
        alert(error);
      });
  }

}
