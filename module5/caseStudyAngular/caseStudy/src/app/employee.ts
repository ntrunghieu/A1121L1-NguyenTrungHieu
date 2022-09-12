import {Level} from './level';
import {Division} from './division';

export interface Employee {
  id?: number;
  name?: string;
  idCard?: string;
  phone?: string;
  email?: string;
  birthday?: string;
  level?: Level;
  position?: Position;
  division?: Division;
  salary?: number;
}
