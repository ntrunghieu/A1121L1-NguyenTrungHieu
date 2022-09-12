import {Facility} from './facility';
import {Customer} from './customer';
import {Employee} from './employee';

export interface Contract {
  id?: number;
  startDay?: string;
  endDay?: string;
  deposit?: string;
  total?: string;
  employee?: Employee;
  customer?: Customer;
  facility?: Facility;


}
