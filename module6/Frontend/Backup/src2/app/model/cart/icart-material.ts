import {ICart} from './icart';
import {IMaterial} from '../material/imaterial';

export interface ICartMaterial {
  cartMaterialId?: number;
  cartId?: ICart;
  cartMaterialFlag?: boolean;
  materialId?: IMaterial;
  cartMaterialReason?: string;
  checked?: boolean;
}
