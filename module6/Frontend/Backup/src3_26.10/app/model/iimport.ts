import {IAccount} from './account/iaccount';
import {IMaterial} from './material/imaterial';

export interface IImport {
  importId?: number;
  importCode?: string;
  importStartDate?: string;
  importQuantity?: number;
  importFlag?: boolean;
  importAccountId?: IAccount;
  importMaterialId?: IMaterial;
}
