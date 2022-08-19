import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment'
import {CrearJuegoCommand} from '../commands/crearJuegoCommand';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http: HttpClient) { }

  crearJuego(command: CrearJuegoCommand){
    return this.http.post(environment.apiBase+"/juego/crear", command);
  }
}
