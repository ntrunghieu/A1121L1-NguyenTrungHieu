import { Component, OnInit } from '@angular/core';
import {CustomerServiceService} from '../../service/customer-service.service';
import {Customer} from '../../customer';
import {Contract} from '../../contract';
import {ContractServiceService} from '../../service/contract-service.service';

@Component({
  selector: 'app-contract-list',
  templateUrl: './contract-list.component.html',
  styleUrls: ['./contract-list.component.css']
})
export class ContractListComponent implements OnInit {
  contracts: Contract [] = [];
  customers: Customer [] = [];
  contractIdToDelete: number;
  totalLength: number;
  p: string | number = 1;
  constructor(private contractService: ContractServiceService) { }

  ngOnInit(): void {
    this.getAll();

  }
  getAll() {
    this.contractService.findAll().subscribe((data) => {
      this.contracts = data;
      this.totalLength = data.length;
    });
  }

  sendContractToDelete(id: number) {
    this.contractIdToDelete = id;
  }
  // delete(contractIdToDelete: string) {
  //   this.contractService.deleteContract(contractIdToDelete).subscribe(() => {
  //     alert('Successful');
  //     this.ngOnInit();
  //   }, e => {
  //     console.log(e);
  //   }, () => {
  //     this.route.navigate(['/contract/list']);
  //   });
  // }
  delete(contractIdToDelete: number) {

  }
}
