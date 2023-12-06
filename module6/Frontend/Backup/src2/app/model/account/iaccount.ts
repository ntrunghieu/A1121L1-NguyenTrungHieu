import {IRole} from './irole';

export interface IAccount {
  accountId?: number;
  username?: string;
  password?: string;
  accountFlag?: boolean;
  roles?: IRole;
}
