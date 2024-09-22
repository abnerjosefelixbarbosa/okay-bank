import { Account } from '../account/Account';
import { Recipient } from '../recipient/Recipient';

export interface Transference {
  id: String;
  dateTime: Date;
  valueTransference: Number;
  account: Account;
  recipient: Recipient;
}