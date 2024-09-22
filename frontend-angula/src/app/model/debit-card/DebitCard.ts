import { Account } from './../account/Account';

export interface DebitCard {
  id: String;
  number: String;
  expirationDate: Date;
  cvv: String;
  account: Account;
}