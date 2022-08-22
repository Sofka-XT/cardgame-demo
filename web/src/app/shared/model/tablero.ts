export interface TableroModel {
    id:string,
    ronda: Ronda,
    tiempo: number,
    tablero: Tablero
}

export interface Tablero {
     jugadores: [],
     cartas: any,
}
export interface Ronda {
    jugadores: [],
    numero: number
}

export interface Carta {
    cartaId:string,
    estaOculta:boolean,
    poder:number,
    estaHabilitada:boolean
}

