import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ApiService } from '../services/api.service';
import { v1 as uuidv1 } from 'uuid';
export class Jugador { 
  constructor(public id:string, public alias:string) {
  }	
} 

@Component({
  selector: 'app-new-game',
  templateUrl: './new-game.component.html',
  styleUrls: ['./new-game.component.scss']
})
export class NewGameComponent implements OnInit, OnDestroy {
  form: FormGroup;
  juegoId: string;
  //TODO: sacarlo de una lista de jugadores
  jugadores: Jugador[] = [
    new Jugador("xxx", "raul"),
    new Jugador("yyy", "pedro"),
    new Jugador("fff", "juan"),
  ]
  constructor(private api: ApiService) {
    this.form = new FormGroup({
      jugador: new FormControl()
    });
    this.juegoId = uuidv1();
   }
 

  ngOnInit(): void {

  }

  ngOnDestroy(): void {
   
  }

  onSubmit(){
    const jugadores = this.form.value.jugador.map((jugador: Jugador) => {
      return [jugador.id, jugador.alias]
    });
    this.api.crearJuego({
      jugadorPrincipalId: "fff",
      juegoId: this.juegoId,
      jugadores:jugadores
    }).subscribe(log => {
      // TODO: trabajar con los pipe
    });
  }
}
