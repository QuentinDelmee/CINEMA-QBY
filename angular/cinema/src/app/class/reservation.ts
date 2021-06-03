import { Movie } from "./movie";
import { Seat } from "./seat";
import { User } from "./user";

export class Reservation {
    id:number ;
    idUser: User ;
    idSeat: Seat ;
    idMovie: Movie;
    idDate:string ;
    date: string ;
    time: string ;

    constructor(reservationJSON:any)
    {
        this.id = reservationJSON.id;
        this.idUser = new User(reservationJSON.idUser) ;
        this.idSeat = new Seat(reservationJSON.idSeat) ;
        this.idMovie = new Movie(reservationJSON.idMovie) ;
        this.date = reservationJSON.date ;
        this.time = reservationJSON.time ;
        this.idDate = this.date+"T"+this.time ;
    }
}
