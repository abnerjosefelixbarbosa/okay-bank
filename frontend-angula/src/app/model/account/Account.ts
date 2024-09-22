import { AccountType } from '../account-type/AccountType';
import { Customer } from './../customer/customer';
import { Agency } from './../agency/Agency';

export interface Account {
  id: String;
  number: String;
  balance: Number;
  accountType: AccountType;
  password: String;
  customer: Customer;
  agency: Agency;
}