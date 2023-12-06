import {IEmployee} from './iemployee';

export interface ISalary {
  salaryId?: number;
  SalaryAdvancePayment?: number;
  salaryFlag?: boolean;
  salaryEmployeeId?: IEmployee;
}
