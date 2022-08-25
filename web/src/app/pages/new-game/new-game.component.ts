import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Jugador } from 'src/app/shared/model/juego';
import { ApiService } from 'src/app/shared/services/api.service';
import { AuthService } from 'src/app/shared/services/auth.service';
import { v1 as uuidv1 } from 'uuid';
import { webSocket } from 'rxjs/webSocket';


@Component({
  selector: 'app-new-game',
  templateUrl: './new-game.component.html',
  styleUrls: ['./new-game.component.scss']
})
export class NewGameComponent implements OnInit, OnDestroy {
  form: FormGroup;
  juegoId: string;
  jugadores?: Jugador[]
  subject: any;

  constructor(private api: ApiService, private auth: AuthService) {
    this.form = new FormGroup({
      jugador: new FormControl()
    });
    this.juegoId = uuidv1();
     
    api.getJugadores().subscribe((jugadores) => {
      this.jugadores = jugadores;
     });
    this.subject = webSocket('ws://localhost:8081/retrieve/'+this.juegoId);
   }
 

  ngOnInit(): void {
    this.subject.subscribe({
      next: (msg: any)=> console.log(msg), // Called whenever there is a message from the server.
      error: (err: any) => console.log(err), // Called if at any point WebSocket API signals some kind of error.
      complete: () => console.log('complete') // Called when connection is closed (for whatever reason).
     });
  }

  ngOnDestroy(): void {
    this.subject.unsubscribe();
  }

  onSubmit(){
 
    const jugadores: any = {};
    this.form.value.jugador.forEach((user:any) => {
      jugadores[user.uid] = user.alias;
    })

    this.api.crearJuego({
      jugadorPrincipalId: this.auth.user.uid,
      juegoId: this.juegoId,
      jugadores:jugadores
    }).subscribe();
  }
}
