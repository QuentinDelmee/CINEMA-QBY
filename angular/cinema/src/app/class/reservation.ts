export class Reservation {
    id:number ;
    idUser: string ;
    idSeat: string ;
    idDate:string ;
    date: string ;
    time: string ;

    constructor(reservationJSON:any)
    {
        this.id = reservationJSON.id;
        this.idUser = reservationJSON.idUser ;
        this.idSeat = reservationJSON.idSeat ;
        this.date = reservationJSON.date ;
        this.time = reservationJSON.time ;
        this.idDate = this.date+"T"+this.time ;
    }
}
