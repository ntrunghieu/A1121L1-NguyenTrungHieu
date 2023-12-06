import {IAccount} from '../account/iaccount';
import {IPositionEmployee} from './iposition-employee';

export interface IEmployee {
  employeeId?: number;
  employeeCode?: string;
  employeeName?: string;
  employeeAvatar?: string;
  employeeDateOfBirth?: string;
  employeeGender?: string;
  employeeAddress?: string;
  employeePhone?: string;
  employeeSalary?: number;
  employeeFlag?: boolean;
  employeeAccountId?: IAccount;
  employeePositionId?: IPositionEmployee;
}
