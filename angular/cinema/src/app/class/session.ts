export class Session {
    id:number;
    idCinema:number;
    idMovie:number;
    idDate:string;
    seatsLeft:string;
    // private List<User> allUsers = new ArrayList<User>();

    constructor(sessionJSON:any){
        this.id = sessionJSON.id;
		this.idCinema = sessionJSON.idCinema;
		this.idMovie = sessionJSON.idMovie;
		this.idDate = sessionJSON.idDate;
		this.seatsLeft = sessionJSON.seatsLeft;
    }
}
