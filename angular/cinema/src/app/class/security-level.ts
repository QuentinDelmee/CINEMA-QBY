export class SecurityLevel {

    id:number;
    roles:string;
    // private List<User> allUsers = new ArrayList<User>();

    constructor(securityLevelJSON:any){
        this.id = securityLevelJSON.id;
        this.roles = securityLevelJSON.roles;
    }
}
