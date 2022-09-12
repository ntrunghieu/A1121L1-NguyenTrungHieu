// import {Customer} from '../customer';
// import {Input} from '@angular/core';
//
// export class CustomerDAO {
//   @Input()
//   static customers: Customer[] = [
//     {
//       id: 1,
//       name: 'hieu',
//       idCard: '2134',
//       date: '2002-03-13',
//       phone: '1234',
//       email: 'hieu@gmail.com',
//       gender: true,
//       address: 'aasd',
//       type: 'asd'
//     },
//     {
//       id: 2,
//       name: 'hung',
//       idCard: '2134',
//       date: '2002-03-13',
//       phone: '1234',
//       email: 'hung@gmail.com',
//       gender: false,
//       address: 'son tra',
//       type: 'vjp pro'
//     },
//     {
//       id: 3,
//       name: 'van',
//       idCard: '2134',
//       date: '2002-03-13',
//       phone: '1234',
//       email: 'van@gmail.com',
//       gender: false,
//       address: 'hai chau',
//       type: 'vjp pro'
//     },
//     {
//       id: 4,
//       name: 'khai',
//       idCard: '2134',
//       date: '2002-03-13',
//       phone: '1234',
//       email: 'khai@gmail.com',
//       gender: false,
//       address: 'hue',
//       type: 'vjp pro'
//     }
//   ];
//   static temp: Customer = {};
//   static customerIdToDelete: number;
//   static customerNameToDelete: string;
//   static getList() {
//     return this.customers;
//   }
//   static getInfor(cus: Customer) {
//     return this.temp = cus;
//   }
//   static deleteById(id: number) {
//     this.customers.splice(this.customers.findIndex( a => a.id === id), 1);
//   }
//   static sendCustomerToDelete(id: number, name: string) {
//     this.customerIdToDelete = id;
//     this.customerNameToDelete = name;
//   }
// }
//
