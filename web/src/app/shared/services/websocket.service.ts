import { Injectable } from '@angular/core';

import { webSocket } from 'rxjs/webSocket';

@Injectable({
  providedIn: 'root'
})
export class WebsocketService {
  subject: any;

  constructor() {}

  connect(juegoId:string){
    this.subject = webSocket('ws://localhost:8081/retrieve/'+juegoId);
    return this.subject;
  }

  close(){
    this.subject.unsubscribe();
  }
}
