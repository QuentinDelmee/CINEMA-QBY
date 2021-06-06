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

  selectedProduct: any = { "poduct": {} , "index":-1 };
  products: Product[] = [];

  ngOnInit(): void {
    this.findAllProduct() ;
  }

  onSubmit(): void{
    if (confirm("Are you sure you want to delete this Product ?")) {
      console.log(this.selectedProduct) ;
      this.productService.delete(this.selectedProduct.product.id).subscribe() ;
      this.products.splice(this.selectedProduct.index,1);
    }
    else {
      console.log("Delete Product ABORTED");
    }
    this.selectedProduct = new Product({});
  }

  findAllProduct() {
    this.productService.findAll().subscribe(data => {
      this.products = data;
    });
  }

  trackProduct(index:number,product:Product)
  {
    return product.id ;
  }

}
