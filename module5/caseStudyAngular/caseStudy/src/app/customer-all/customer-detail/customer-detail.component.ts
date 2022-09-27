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
  id:number;
  // tslint:disable-next-line:no-input-rename
  // @Input('cus-detail')
  // cus: Customer = {};
  // // tslint:disable-next-line:no-output-rename
  // @Output('cus-delete')
  // deleteCus: EventEmitter<number> = new EventEmitter();
  constructor(private customerService: CustomerServiceService,
              private activedRouter: ActivatedRoute,
              private route: Router) { }
  ngOnInit(): void {
    this.id = this.activedRouter.snapshot.params.id;
    this.customerService.findByIdCustomer(this.id).subscribe(
      data => {
        this.cus = data;
        console.log(this.cus);
      }
    );

  }

  // delete(id: string) {
  //   // this.customers.splice(this.customers.findIndex( a => a.id === id), 1);
  //   // this.deleteCus.emit(this.cus);
  //   this.cus.id = Number(id);
  //   this.deleteCus.emit(this.cus.id);
  // }
  onSubmit() {
  }

  back() {
    this.route.navigateByUrl("customer");
  }
}
