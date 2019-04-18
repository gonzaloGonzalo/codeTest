import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Persona } from '../model/persona';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {

  private baseUrl = 'http://localhost:8080/trmxtst/api/personas';
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});

  constructor( private http: HttpClient ) {
      console.log('Servicio Personas Funcionando');
    }

    getPersonas(): Observable<Persona[]> {
      return this.http.get(this.baseUrl)
      .pipe(
        map(data =>
          { console.log(data)
            return data as Persona[]
          })
      );
    }

    getPersona(id: number): Observable<Persona> {
      return this.http.get<Persona>(`${this.baseUrl}/${id}`);
    }

    createPersona(persona: Persona): Observable<Persona> {
      return this.http.post<Persona>(this.baseUrl, persona, {headers: this.httpHeaders});
    }

    updatePersona(persona: Persona): Observable<Persona> {
      return this.http.put<Persona>(this.baseUrl, persona, {headers: this.httpHeaders});
    }

    deletePersona(id: number): Observable<Persona> {
      return this.http.delete<Persona>(`${this.baseUrl}/${id}`, {headers: this.httpHeaders});
    }
}
