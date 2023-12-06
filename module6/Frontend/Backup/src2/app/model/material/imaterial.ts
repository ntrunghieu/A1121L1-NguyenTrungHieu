import {IMaterialType} from './imaterial-type';
import {ICustomer} from '../customer/icustomer';

export interface IMaterial {
  materialId?: number;
  materialCode?: string;
  materialName?: string;
  materialPrice?: number;
  materialQuantity?: number;
  materialExpiridate?: string;
  materialImage?: string;
  materialDescribe?: string;
  materialFlag?: boolean;
  materialUnit?: string;
  materialTypeId?: IMaterialType;
  materialCustomerId?: ICustomer;
}
