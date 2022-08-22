import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import {CrearJuegoCommand} from '../commands/crearJuegoCommand';
import { Jugador } from '../model/juego';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  jugadores: Jugador[] = [
    {uid: 'ffff', alias: 'raul'},
    {uid: 'xxx', alias: 'andres'},
    {uid: 'ggggg', alias: 'pedro'}
  ];
  constructor(private http: HttpClient) { }

  crearJuego(command: CrearJuegoCommand){
    return this.http.post(environment.apiBase + '/juego/crear', command);
  }

  getJugadores(): Observable<Jugador[]>{
    //TODO: consumidor para consultar los usuarios
    return new Observable(subscriber => {
      subscriber.next(this.jugadores);
      subscriber.complete();
    });
  }

  //TODO: consulta de mis juegos
  getMisJuegos(uid:string){}

  //TODO: consulta de mi mazo
  getMiMazo(uid:string, juegoId:string){}

  //TODO: consulta tablero del juego
  getTablero(juegoId:string){}
}
