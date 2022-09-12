import { Component, OnInit } from '@angular/core';
import {Product} from '../../model/product';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-product-update',
  templateUrl: './product-update.component.html',
  styleUrls: ['./product-update.component.css']
})
export class ProductUpdateComponent implements OnInit {
  product: Product;
  product1: FormGroup;
  productUpdate: Product;
  id: number;
  constructor(
    private service: ProductService,
    private activated: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.id = this.activated.snapshot.params.id;
    // this.product = this._service.findById(this.id);
    this.service.findById(this.id).subscribe(data => {
        this.productUpdate = data;
      }, error => {
        console.log('errors');
      }
    );
    console.log(this.product);
    this.product1 = new FormGroup(
      {
        id: new FormControl('', [Validators.required]),
        name: new FormControl('', [Validators.required]),
        price: new FormControl('', [Validators.required, Validators.min(0)] ),
        description: new FormControl('', [Validators.required])
      }
    );
    this.product1.setValue(this.product);
  }

  save() {
    this.service.update(this.product1.value.id, this.product1.value).subscribe(() => {
      console.log('success');
      this.router.navigateByUrl('');
    });
    // this._service.update(this.product1.value);
  }
}
