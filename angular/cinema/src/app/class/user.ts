<<<<<<< HEAD
import {Person} from '../class/person'
=======
import { Person } from "./person";
>>>>>>> 7d4de256010cffdcb63aafbf2d4c16f9b56ed8d7

export class User {
    id:number;
    pseudo:string;
    pwd:string;
    idPerson:Person;
<<<<<<< HEAD
    idSecurityLevel:number;
=======
>>>>>>> 7d4de256010cffdcb63aafbf2d4c16f9b56ed8d7


    constructor(userJSON:any){
        this.id = userJSON.id;
        this.pseudo = userJSON.pseudo;
        this.pwd = userJSON.pwd;
<<<<<<< HEAD
        this.idPerson = userJSON.idPerson;
        this.idSecurityLevel = userJSON.idSecurityLevel;
=======
        this.idPerson = new Person(userJSON.idPerson);
>>>>>>> 7d4de256010cffdcb63aafbf2d4c16f9b56ed8d7

    }

    // private Person idPerson;

    // private SecurityLevel idSecurityLevel;

    // private List<Opinion> myOpinions = new ArrayList<Opinion>();

    // private List<Commentary> myCommentary = new ArrayList<Commentary>();

    // private List<Purchase> myPurchase = new ArrayList<Purchase>();

    // private List<Reservation> myReservation = new ArrayList<Reservation>();

}
