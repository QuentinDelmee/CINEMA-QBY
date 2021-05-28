export class CinemaRoom {

    id:number ;
    roomName:string ;
    roomLevel:string;
    screenSize:number ;

    constructor(cinemaRoomJSON:any)
    {
        this.id = cinemaRoomJSON.id;
        this.roomName = cinemaRoomJSON.title ;
        this.roomLevel = cinemaRoomJSON.originalTitle ;
        this.screenSize = cinemaRoomJSON.pegi ;
    }
}
