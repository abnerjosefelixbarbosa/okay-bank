import { Account } from './../account/Account';

export interface IDebitCard {
  id: String;
  number: String;
  expirationDate: Date;
  cvv: String;
  account: Account;
}