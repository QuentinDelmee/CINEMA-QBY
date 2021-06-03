export class CinemaRoom {

    id:number ;
    roomName:string ;
    roomLevel:string;
    screenSize:number ;

    constructor(cinemaRoomJSON:any)
    {
        this.id = cinemaRoomJSON.id;
        this.roomName = cinemaRoomJSON.roomName ;
        this.roomLevel = cinemaRoomJSON.roomLevel ;
        this.screenSize = cinemaRoomJSON.screenSize ;
    }
}
