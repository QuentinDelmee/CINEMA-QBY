export class SecurityLevel {

    id:number;
    role:string;
    description:string;
    // private List<User> allUsers = new ArrayList<User>();

    constructor(securityLevelJSON:any){
        this.id = securityLevelJSON.id;
        this.role = securityLevelJSON.role;
        this.description = securityLevelJSON.description ;
    }
}
