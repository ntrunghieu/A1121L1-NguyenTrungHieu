import {ICustomerType} from './icustomer-type';

export interface ICustomer {
  customerId?: number;
  customerName?: string;
  customerCode?: string;
  customerAvatar?: string;
  customerAddress?: string;
  customerPhone?: string;
  customerEmail?: string;
  customerFlag?: boolean;
  customerTypeId?: ICustomerType;
  checked?: boolean;
}
