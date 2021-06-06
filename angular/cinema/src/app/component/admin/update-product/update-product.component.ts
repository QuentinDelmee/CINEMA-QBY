import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/class/product';
import { ProductService } from 'src/app/service/product.service';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.scss']
})
export class UpdateProductComponent implements OnInit {

  selectedProduct: Product = new Product({});
  products: Product[] = []

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.findAllProduct() ;
  }
  
  findAllProduct() {
    this.productService.findAll().subscribe(data => {
      this.products = data;
    });
  }

  onSubmit(): void {
    if (confirm("Are you sure you want to update this Product ?")) {
      this.productService.save(this.selectedProduct).subscribe();
    }
    else {
      console.log("Update Product ABORTED");
    }

    this.selectedProduct = new Product({});
  }
}
