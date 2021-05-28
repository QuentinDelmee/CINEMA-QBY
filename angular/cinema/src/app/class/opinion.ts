export class Opinion {
    idCinema:number;
    idUser:number;
    rating:number;
    cleanlyness:string;
    id:number;


    constructor(opinionJSON:any)
    {
        this.id = opinionJSON.id;
        this.idCinema = opinionJSON.idCinema;
		this.idUser = opinionJSON.idUser;
		this.rating = opinionJSON.rating;
		this.cleanlyness = opinionJSON.cleanlyness;
        this.id = 0 ;
    }
}
