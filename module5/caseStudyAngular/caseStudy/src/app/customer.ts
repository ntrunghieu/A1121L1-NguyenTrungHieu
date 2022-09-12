import {TypeCustomer} from './type-customer';

export interface Customer {
  id?: number;
  name?: string;
  idCard?: string;
  date?: string;
  phone?: string;
  email?: string;
  gender?: boolean;
  address?: string;
  type?: TypeCustomer;

}
