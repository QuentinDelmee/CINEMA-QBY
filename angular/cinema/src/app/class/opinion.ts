import { CinemaRoom } from "./cinema-room";

export class Opinion {
    idCinemaRoom:CinemaRoom;
    idUser:number;
    rating:number;
    cleanlyness:string;
    id:number;


    constructor(opinionJSON:any)
    {
        this.id = opinionJSON.id;
        this.idCinemaRoom = new CinemaRoom(opinionJSON.idCinemaRoom);
		this.idUser = opinionJSON.idUser;
		this.rating = opinionJSON.rating;
		this.cleanlyness = opinionJSON.cleanlyness;
    }
}
