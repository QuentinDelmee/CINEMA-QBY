import { Person } from "./person";

export class User {
    id:number;
    pseudo:string;
    pwd:string;
    idPerson:Person;


    constructor(userJSON:any){
        this.id = userJSON.id;
        this.pseudo = userJSON.pseudo;
        this.pwd = userJSON.pwd;
        this.idPerson = new Person(userJSON.idPerson);

    }

    // private Person idPerson;

    // private SecurityLevel idSecurityLevel;

    // private List<Opinion> myOpinions = new ArrayList<Opinion>();

    // private List<Commentary> myCommentary = new ArrayList<Commentary>();

    // private List<Purchase> myPurchase = new ArrayList<Purchase>();

    // private List<Reservation> myReservation = new ArrayList<Reservation>();

}
