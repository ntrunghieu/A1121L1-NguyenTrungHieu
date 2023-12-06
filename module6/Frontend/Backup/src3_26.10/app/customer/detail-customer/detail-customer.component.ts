import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {ICustomer} from '../../model/customer/icustomer';
import {CustomerServiceService} from '../../service/customer/customer-service.service';

@Component({
  selector: 'app-detail-customer',
  templateUrl: './detail-customer.component.html',
  styleUrls: ['./detail-customer.component.css']
})
export class DetailCustomerComponent implements OnInit {
  customerDetail: ICustomer = {
    customerTypeId: {}
  };
  idCustomer: number;

  constructor(private customerService: CustomerServiceService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((param) => {
      this.idCustomer = +param.get('id');
      this.findCustomerById(this.idCustomer);
    });
  }

  findCustomerById(idEmployee: number) {
    this.customerService.findCustomerById(idEmployee).subscribe(
      (data) => {
        this.customerDetail = data;
      },
      (error) => {
        if (error.status === 404) {
          this.router.navigateByUrl('/error404');
        }
      }
    );
  }
}
