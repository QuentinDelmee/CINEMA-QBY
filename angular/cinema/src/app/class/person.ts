export class Person {
	id:any;
	familyName:string;
	firstName:string;
	//private LocalDate date;
	genre:string;
	city:string;
	email:string;

	constructor(personJSON:any){
		this.id = personJSON.id;
		this.familyName = personJSON.familyName;
		this.familyName= personJSON.familyName;
		this.genre = personJSON.genre;
		this.city = personJSON.city;
		this.email = personJSON.email;
	}




    

    // private User idUser;
}
