import {District} from './district';

export interface ProvinceCity {
  name?: string;
  code?: number;
  codename?: string;
  division_type?: string;
  phone_code?: number;
  districts?: District;
}
