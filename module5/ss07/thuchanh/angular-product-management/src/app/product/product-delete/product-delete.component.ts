import { Component, OnInit } from '@angular/core';
import {Product} from '../../model/product';
import {ActivatedRoute, Router} from '@angular/router';
import {ProductService} from '../../service/product.service';

class ProductServiceService {
}

@Component({
  selector: 'app-product-delete',
  templateUrl: './product-delete.component.html',
  styleUrls: ['./product-delete.component.css']
})
export class ProductDeleteComponent implements OnInit {
  productDelete: Product;
  id: number;
  constructor(
    private _router: Router,
    private _activated: ActivatedRoute,
    private _service: ProductService
  ) { }

  ngOnInit(): void {
    this.id = this._activated.snapshot.params.id;
    // this.productDelete = this._service.findById(this.id);
    this._service.findById(this.id).subscribe(data => {
      this.productDelete = data;
    }, error => {
      console.log('errors');
    });
  }

  close() {
    this._router.navigateByUrl('');
  }

  delete() {
    this._service.delete(this.productDelete.id);
    this._router.navigateByUrl('');
    alert('Da xoa ' + this.productDelete.name);
  }
}
