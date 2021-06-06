import { CinemaRoom } from "./cinema-room";

export class Seat {

    id:number
    seatNumber:number ;
    rowName:string ;
    free:boolean;
    idCinemaRoom:CinemaRoom ;

    constructor(seatJSON:any)
    {
        this.id = seatJSON.id;
        this.seatNumber = seatJSON.seatNumber;
		this.rowName = seatJSON.rowName;
		this.free = seatJSON.free;
		this.idCinemaRoom = new CinemaRoom(seatJSON.idCinema);
    }
}
