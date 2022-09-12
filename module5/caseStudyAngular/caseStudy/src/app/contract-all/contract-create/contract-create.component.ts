import { Component, OnInit } from '@angular/core';
import {TypeCustomer} from '../../type-customer';
import {TypeCustomerService} from '../../service/type-customer.service';
import {EmployeeServiceService} from '../../service/employee-service.service';
import {Customer} from '../../customer';
import {Employee} from '../../employee';
import {Facility} from '../../facility';
import {FacilityServiceService} from '../../service/facility-service.service';
import {CustomerServiceService} from '../../service/customer-service.service';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {ContractServiceService} from '../../service/contract-service.service';

@Component({
  selector: 'app-contract-create',
  templateUrl: './contract-create.component.html',
  styleUrls: ['./contract-create.component.css']
})
export class ContractCreateComponent implements OnInit {
  createContractForm: any;
  typeCus: TypeCustomer[] = [];
  customers: Customer[] = [];
  employees: Employee[] = [];
  facilities: Facility[] = [];
  constructor(private type: TypeCustomerService,
              private customerService: CustomerServiceService,
              private employeeService: EmployeeServiceService,
              private facilityService: FacilityServiceService,
              private contractService: ContractServiceService,
              private route: Router) {
    this.createContractForm = new FormGroup({
      id: new FormControl('', [Validators.required, Validators.pattern(/^[H]{1}[D]{1}[-]{1}[0-9]{4}$/)]),
      customer: new FormControl('', Validators.required),
      facility: new FormControl('', Validators.required),
      startDay: new FormControl('', Validators.required),
      endDay: new FormControl('', Validators.required),
      deposit: new FormControl('', [Validators.required, Validators.pattern(/^[1-9]{1}[0-9]{0,}$/)]),
      total: new FormControl('', [Validators.required, Validators.pattern(/^[1-9]{1}[0-9]{0,}$/)]),
    });
  }

  ngOnInit(): void {
    // this.getTypeCustomer()
    this.getEmployee();
    this.getCustomer();
    this.getFacility();
  }

  onSubmit() {
    this.contractService.addContract(this.createContractForm.value).subscribe(data => {
      console.log(data);
      alert('Successful');
      this.route.navigateByUrl('/contract');
    }, () => {
      console.log('error');
    });

  }
  getTypeCustomer() {
    this.type.findAll().subscribe((data) => {
      this.typeCus = data;
    });
  }
  getEmployee(){
    this.employeeService.findAll().subscribe((data) => {
      this.employees = data;
      console.log(this.employees.values());
    });
  }
  getFacility(){
    this.facilityService.findAll().subscribe((data) => {
      this.facilities = data;
    });
  }
  getCustomer(){
    this.customerService.findAll().subscribe((data) => {
      this.customers = data;
    });
  }
}
