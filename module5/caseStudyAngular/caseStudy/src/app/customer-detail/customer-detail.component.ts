import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Customer} from '../customer';
import {CustomerComponent} from '../customer/customer.component';

@Component({
  selector: 'app-customer-detail',
  templateUrl: './customer-detail.component.html',
  styleUrls: ['./customer-detail.component.css']
})
export class CustomerDetailComponent implements OnInit {
  // tslint:disable-next-line:no-input-rename
  @Input('cus-detail')
  cus: Customer = {};
  // tslint:disable-next-line:no-output-rename
  @Output('cus-delete')
  deleteCus: EventEmitter<number> = new EventEmitter();
  customers: Customer[] = [
    {
      id: 1,
      name: 'hieu',
      idCard: '2134',
      phone: '1234',
      email: 'hieu@gmail.com',
      gender: true,
      address: 'aasd',
      type: 'asd'
    },
    {
      id: 2,
      name: 'hung',
      idCard: '2134',
      phone: '1234',
      email: 'hung@gmail.com',
      gender: false,
      address: 'son tra',
      type: 'vjp pro'
    }
  ];
  constructor() { }
  ngOnInit(): void {
  }

  delete(id: string) {
    // this.customers.splice(this.customers.findIndex( a => a.id === id), 1);
    // this.deleteCus.emit(this.cus);
    this.cus.id = Number(id);
    this.deleteCus.emit(this.cus.id);
  }
}
