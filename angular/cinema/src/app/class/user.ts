import { Person } from "./person";
import { SecurityLevel } from "./security-level";

export class User {
    id:number;
    pseudo:string;
    pwd:string;
    idPerson:Person;
    idSecurityLevel:SecurityLevel;


    constructor(userJSON:any){
        this.id = userJSON.id;
        this.pseudo = userJSON.pseudo;
        this.pwd = userJSON.pwd;
        this.idPerson = new Person(userJSON.idPerson);
        this.idSecurityLevel = new SecurityLevel(userJSON.idSecurityLevel);

    }
}
