import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/class/product';
import { ProductService } from 'src/app/service/product.service';

@Component({
  selector: 'app-delete-product',
  templateUrl: './delete-product.component.html',
  styleUrls: ['./delete-product.component.scss']
})
export class DeleteProductComponent implements OnInit {

  constructor(private productService: ProductService) { }

  selectedProduct: any = { "movie":{} , "index":-1 } ;
  products: Product[] = [];

  ngOnInit(): void {
    this.findAllMovie() ;
  }

  onSubmit(): void{
    if (confirm("Are you sure you want to delete this Movie ?")) {
      console.log(this.selectedProduct) ;
      this.productService.delete(this.selectedProduct.movie.id).subscribe() ;
      this.products.splice(this.selectedProduct.index,1);
    }
    else {
      console.log("Delete Movie ABORTED");
    }
    this.selectedProduct = { "movie":{} , "index":-1};
  }

  findAllMovie() {
    this.productService.findAll().subscribe(data => {
      this.products = data;
    });
  }

  trackProduct(index:number,product:Product)
  {
    return product.id ;
  }

}
