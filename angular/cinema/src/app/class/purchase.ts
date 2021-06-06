import { Product } from "./product";
import { User } from "./user";

export class Purchase {
    id:number ;
    idProduct:Product ;
    idUser:User;
    idDate:string ;
    quantity:number;
    idReceipt:number;
    date:string ;
    time: string ;

    constructor(cinemaRoomJSON:any)
    {
        this.id = cinemaRoomJSON.id ;
        this.idProduct = new Product(cinemaRoomJSON.idProduct) ;
        this.idUser = new User(cinemaRoomJSON.idUser) ;
        this.idDate = cinemaRoomJSON.idDate ;
        this.quantity = cinemaRoomJSON.quantity ;
        this.idReceipt = cinemaRoomJSON.idReceipt ;
        this.date = cinemaRoomJSON.data ;
        this.time = cinemaRoomJSON.time ;
    }
}
