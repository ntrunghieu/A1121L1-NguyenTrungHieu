import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ProductService} from '../../service/product.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  product: FormGroup;
  constructor(
    private _service: ProductService,
    private _router: Router
  ) { }

  ngOnInit(): void {
    this.product = new FormGroup(
      {
        id: new FormControl('', [ Validators.required]),
        name: new FormControl('', [ Validators.required]),
        price: new FormControl('', [Validators.required, Validators.min(0)] ),
        description: new FormControl('', [Validators.required])
      }
    );
  }

  save() {
    // this._service.add(this.product.value);
    this._service.save(this.product.value).subscribe( () => {
      console.log('success');
      this._router.navigateByUrl('');
    });
  }
}
