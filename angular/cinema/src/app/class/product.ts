export class Product {

    id:number;
    productName:string;
    price:number;
    category:string;
    productDescription:string;


    constructor(productJSON:any){
        this.id = productJSON.id;
        this.productName= productJSON.productName;
        this.price= productJSON.price;
        this.category= productJSON.category;
        this.productDescription= productJSON.productDescription;
    }
}
