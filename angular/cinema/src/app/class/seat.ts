export class Seat {

    id:number
    seatNumber:number ;
    rowName:string ;
    free:boolean;
    idCinema:number ;

    constructor(seatJSON:any)
    {
        this.id = seatJSON.id;
        this.seatNumber = seatJSON.seatNumber;
		this.rowName = seatJSON.rowName;
		this.free = seatJSON.free;
		this.idCinema = seatJSON.idCinema;
    }
}
