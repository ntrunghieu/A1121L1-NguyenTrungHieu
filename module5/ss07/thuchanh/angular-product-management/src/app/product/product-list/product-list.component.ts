import { Component, OnInit } from '@angular/core';
import {ProductService} from '../../service/product.service';
import {Product} from '../../model/product';
import {Category} from '../../model/category';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  page: number = 1;
  products: Product[] = [];
  category: Category;
  // products: Product[] = [];
  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.getAllEm();
  }
  getAllEm() {
    // this.products = this.productService.getAll();
     this.productService.getAll(this.page).subscribe((data) => {
      this.products = data;
      console.log(data);
    }, () => {
      console.log('ERRORS');
    });
  }
  back() {
    if (this.page > 1) {
      this.page = this.page - 1;
      this.ngOnInit();
    }
  }
  next() {
    this.page = this.page + 1 ;
    this.ngOnInit();
  }

  searchAll(value: string, value1: string) {
    this.productService.search(value, value1).subscribe(data => {
      this.products = data;
      console.log(this.products);
      console.log(value, value1);
    });
  }

  // sort() {
  //   this._service.sort().subscribe(data => {
  //     this.products = data;
  //   })
  // }
}
