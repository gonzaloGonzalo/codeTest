import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { PersonaService } from '../../services/persona.service';

@Component({
  selector: 'app-add-persona',
  templateUrl: './add-persona.component.html',
  styles: []
})
export class AddPersonaComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private router: Router, private service: PersonaService) { }

    addForm: FormGroup;

    ngOnInit() {
      this.addForm = this.formBuilder.group({
        id: [],
        nombre: ['', Validators.required],
        apellido: ['', Validators.required],
        fechaNacimiento: ['', Validators.required],
        tipoDocumento: ['', Validators.required],
        numeroDocumento: ['', Validators.required]
      });
    }

    onSubmit() {
      this.service.createPersona( this.addForm.value )
        .subscribe(data => {
          this.router.navigate(['list-persona']);
        });
    }

}
