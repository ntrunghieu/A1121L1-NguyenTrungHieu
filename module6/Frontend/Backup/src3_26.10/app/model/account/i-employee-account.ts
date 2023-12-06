import {IEmployee} from '../employee/iemployee';
import {IAccount} from './iaccount';

export interface IEmployeeAccount {
  employee?: IEmployee;
  account?: IAccount;
}
