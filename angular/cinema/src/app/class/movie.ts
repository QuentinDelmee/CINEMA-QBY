export class Movie {
    id:number ;
    title:string ;
    originalTitle:string;
    pegi:number ;
    releaseDate:number;
    movieDuration:string;
    movieGenre:string;
    averageRating:number;
    movieDescription:string;

    constructor(movieJSON:any)
    {
        this.id = movieJSON.id ;
        this.title = movieJSON.title ;
        this.originalTitle = movieJSON.originalTitle ;
        this.pegi = movieJSON.pegi ;
        this.releaseDate = movieJSON.releaseDate ;
        this.movieDuration = movieJSON.movieDuration ;
        this.movieGenre = movieJSON.movieGenre ;
        this.averageRating = movieJSON.averageRating ;
        this.movieDescription = movieJSON.movieDescription ;
    }
}
