export interface CrearJuegoCommand {
     juegoId:string,
     jugadores: Map<string, string>;
     jugadorPrincipalId: string;
}

