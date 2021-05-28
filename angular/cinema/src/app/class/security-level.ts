export class SecurityLevel {

    id ;
    roles ="";
    // private List<User> allUsers = new ArrayList<User>();

    constructor(id:number, roles:string){
        this.id = id;
        this.roles = roles;
    }
}
