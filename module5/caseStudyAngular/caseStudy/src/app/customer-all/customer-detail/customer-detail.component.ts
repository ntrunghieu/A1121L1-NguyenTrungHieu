import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Customer} from '../../customer';
import {CustomerComponent} from '../customer/customer.component';
import {CustomerServiceService} from '../../service/customer-service.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-customer-detail',
  templateUrl: './customer-detail.component.html',
  styleUrls: ['./customer-detail.component.css']
})
export class CustomerDetailComponent implements OnInit {
  cus: Customer | undefined;
  // tslint:disable-next-line:no-input-rename
  // @Input('cus-detail')
  // cus: Customer = {};
  // // tslint:disable-next-line:no-output-rename
  // @Output('cus-delete')
  // deleteCus: EventEmitter<number> = new EventEmitter();
  constructor(private customerService: CustomerServiceService,
              private activedRouter: ActivatedRoute) { }
  ngOnInit(): void {
    this.activedRouter.paramMap.subscribe((param) => {
      const id = parseInt(<string> param.get('id'));
      this.cus = this.customerService.findByID(id);
    });

  }

  // delete(id: string) {
  //   // this.customers.splice(this.customers.findIndex( a => a.id === id), 1);
  //   // this.deleteCus.emit(this.cus);
  //   this.cus.id = Number(id);
  //   this.deleteCus.emit(this.cus.id);
  // }
}
