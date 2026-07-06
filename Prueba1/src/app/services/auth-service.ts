import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private urlAuth = 'http://localhost:8080/api/test/v1/angular/autenticacion';
  private urlUsuarios = 'http://localhost:8080/api/test/v1/angular/usuarios';

  constructor(private http: HttpClient) {}

  login(usuario: string, clave: string): Observable<any> {
    return this.http.post(this.urlAuth, {
      usuario: usuario,
      clave: clave
    });
  }

  obtenerUsuarios(): Observable<any> {
    return this.http.get(this.urlUsuarios);
  }
}