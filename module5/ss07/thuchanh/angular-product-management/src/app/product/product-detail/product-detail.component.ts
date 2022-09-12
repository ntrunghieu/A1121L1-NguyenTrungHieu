import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {ProductService} from '../../service/product.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {
  productForm: FormGroup = new FormGroup({
    id: new FormControl(),
    name: new FormControl(),
    price: new FormControl(),
    description: new FormControl()
  });

  constructor(private productService: ProductService,
              private route: Router) { }

  ngOnInit(): void {
  }
  submit() {
    const product = this.productForm.value;
    // this.productService.saveProduct(product);
    this.productForm.reset();
    this.route.navigateByUrl('product/list');
  }

  back() {
    this.route.navigateByUrl('product/list');
  }

}
