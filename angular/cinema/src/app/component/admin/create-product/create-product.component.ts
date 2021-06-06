import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/class/product';
import { ProductService } from 'src/app/service/product.service';

@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.scss']
})
export class CreateProductComponent implements OnInit {

  productJSON: any = {};

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
  }

  onSubmit(): void {
    if (confirm("Are you sure you want to create this Movie ?")) {
      let toPost: Product = this.productJSON;
      this.productService.save(toPost).subscribe();
    }
    else {
      console.log("New Movie ABORTED");
    }

    this.productJSON = {} ;
  }

}
