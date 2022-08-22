import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Jugador } from 'src/app/shared/model/juego';
import { ApiService } from 'src/app/shared/services/api.service';
import { AuthService } from 'src/app/shared/services/auth.service';
import { v1 as uuidv1 } from 'uuid';


@Component({
  selector: 'app-new-game',
  templateUrl: './new-game.component.html',
  styleUrls: ['./new-game.component.scss']
})
export class NewGameComponent implements OnInit, OnDestroy {
  form: FormGroup;
  juegoId: string;
  jugadores?: Jugador[]
  //TODO: sacarlo de una lista de jugadores

  constructor(private api: ApiService, private auth: AuthService) {
    this.form = new FormGroup({
      jugador: new FormControl()
    });
    this.juegoId = uuidv1();
     
    api.getJugadores().subscribe((jugadores) => {
      this.jugadores = jugadores;
     });
     
   }
 

  ngOnInit(): void {

  }

  ngOnDestroy(): void {
   
  }

  onSubmit(){
 
    const jugadores: any = {};
    this.form.value.jugador.forEach((user:any) => {
      jugadores[user.uid] = user.displayName;
    })
    this.api.crearJuego({
      jugadorPrincipalId: this.auth.user.uid,
      juegoId: this.juegoId,
      jugadores:jugadores
    }).subscribe();
  }
}
