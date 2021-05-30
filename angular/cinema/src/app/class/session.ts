export class Session {
    id:number;
    idCinema:string;
    idMovie:string;
    idDate:string;
    seatsLeft:string;
    date:string;
    time:string;

    constructor(sessionJSON:any){
        this.id = sessionJSON.id;
		this.idCinema = sessionJSON.idCinema;
		this.idMovie = sessionJSON.idMovie;
        this.date = sessionJSON.date ;
        this.time = sessionJSON.time ;
		this.idDate = this.date + "T" + this.time ;
		this.seatsLeft = sessionJSON.seatsLeft;
    }
}
