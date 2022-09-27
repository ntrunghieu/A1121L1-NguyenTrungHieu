import {TypeCustomer} from './type-customer';

export interface Customer {
  customerId?: number;
  customerName?: string;
  customerIdCard?: string;
  customerBirthday?: string;
  customerPhone?: string;
  customerEmail?: string;
  customerGender?: boolean;
  customerAddress?: string;
  customerType?: TypeCustomer;

}
