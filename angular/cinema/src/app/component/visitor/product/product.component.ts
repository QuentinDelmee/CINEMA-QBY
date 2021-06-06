import { Component, HostListener, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/class/product';
import { ProductService } from 'src/app/service/product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss']
})
export class ProductComponent implements OnInit {

  /* ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- */

  products: Product[] = [] ;

  /* ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- */
  nbColumn: number = 12;
  nbColSpan: number = 3;
  nbGutterSize: number = 24;
  innerWidth: number = 1440;

  constructor(private productService: ProductService,private router:Router) { }

  ngOnInit(): void {
    this.onResize();
    this.findAllProduct();
  }

  findAllProduct() {
    this.productService.findAll().subscribe(data => {
      this.products = data;
    });
  }

  image(product: any): string {
    if (product.imageUrl === "N/A" || !product.imageUrl || product.imageUrl === "") {
      return '../../../assets/img/image-not-found.png';
    }
    else { return product.imageUrl; }
  }

  /* ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- */

  @HostListener('window:resize', ['$event'])
  onResize() {
    this.innerWidth = window.innerWidth;
    this.updateColumn();
  }

  updateColumn(): void {
    if (this.innerWidth > 1240) {
      this.nbColumn = 12;
      this.nbColSpan = 3;
      this.nbGutterSize = 24;
    }
    else if (this.innerWidth > 904) {
      this.nbColumn = 12;
      this.nbColSpan = 4;
      this.nbGutterSize = 24;
    }
    else if (this.innerWidth > 599) {
      this.nbColumn = 8;
      this.nbColSpan = 4;
      this.nbGutterSize = 24;
    }
    else {
      this.nbColumn = 4;
      this.nbColSpan = 2;
      this.nbGutterSize = 16;
    }
  }
}
