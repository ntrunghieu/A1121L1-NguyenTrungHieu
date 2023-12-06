import {IMaterial} from './imaterial';

export interface PageMaterial {
  content: IMaterial[];
  totalPages: number;
  number: number;
}
