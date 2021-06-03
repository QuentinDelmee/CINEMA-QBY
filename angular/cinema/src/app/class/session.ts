import { CinemaRoom } from "./cinema-room";
import { Movie } from "./movie";

export class Session {
    id:number;
    idCinemaRoom:CinemaRoom ;
    idMovie:Movie;
    idDate:string;
    seatsLeft:string;
    date:string;
    time:string;

    constructor(sessionJSON:any){
        this.id = sessionJSON?.id ;
		this.idCinemaRoom = new CinemaRoom(sessionJSON.idCinema);
		this.idMovie = new Movie(sessionJSON.idMovie);
        this.date = sessionJSON.date ;
        this.time = sessionJSON.time ;
		this.idDate = this.date + "T" + this.time ;
		this.seatsLeft = sessionJSON.seatsLeft;
    }

    setJSON(sessionJSON:any)
    {
        this.id = sessionJSON?.id ;
		this.idCinemaRoom = new CinemaRoom(sessionJSON.idCinema);
		this.idMovie = new Movie(sessionJSON.idMovie);
        this.date = sessionJSON.date ;
        this.time = sessionJSON.time ;
		this.idDate = this.date + "T" + this.time ;
		this.seatsLeft = sessionJSON.seatsLeft;
    }
}
