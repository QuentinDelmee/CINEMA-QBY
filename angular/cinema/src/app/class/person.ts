export class Person {
	id:number;
	familyName:string;
	firstName:string;
	birthdate:string;
	genre:string;
	city:string;
	email:string;
	idUser:number;

	constructor(personJSON:any){
		this.id = personJSON.id;
		this.firstName = personJSON.firstName;
		this.familyName= personJSON.familyName;
		this.birthdate= personJSON.birthdate;
		this.genre = personJSON.genre;
		this.city = personJSON.city;
		this.email = personJSON.email;
		this.idUser = personJSON.idUser;
	}




}
