export class Commentary {
    id:number;
    rating:number ;
    commentary:string ;
    idUser:number;
    idMovie:number ;

    constructor(commentaryJSON:any)
    {
        this.id = commentaryJSON.id;
        this.rating = commentaryJSON.rating;
		this.commentary = commentaryJSON.commentary;
		this.idUser = commentaryJSON.idUser;
		this.idMovie = commentaryJSON.idMovie;
    }
}
