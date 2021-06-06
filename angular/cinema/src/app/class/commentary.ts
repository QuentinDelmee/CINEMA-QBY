import { Movie } from "./movie";
import { User } from "./user";

export class Commentary {
    id:number;
    rating:number ;
    commentary:string ;
    idUser:User;
    idMovie:Movie ;

    constructor(commentaryJSON:any)
    {
        this.id = commentaryJSON.id;
        this.rating = commentaryJSON.rating;
		this.commentary = commentaryJSON.commentary;
		this.idUser = new User(commentaryJSON.idUser);
		this.idMovie = new Movie(commentaryJSON.idMovie);
    }
}
