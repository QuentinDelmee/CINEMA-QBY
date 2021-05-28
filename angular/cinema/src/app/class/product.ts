export class Product {

    id;
    productName ="";
    price;
    category ="";
    productDescription ="";


    constructor(id:number,productName:string,price:number,category:string,productDescription:string ){
        this.id = id;
        this.productName=productName;
        this.price=price;
        this.category=category;
        this.productDescription=productDescription;

    }
}
