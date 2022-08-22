export interface MazoModel {
    cantidad:number,
    cartas: Carta[]
}

export interface Carta {
    cartaId:string,
    poder: number,
    estaOculta:boolean,
    estaHabilitada:boolean,
}

