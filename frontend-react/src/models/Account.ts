import { Customer } from "./Customer";

export interface Account {
  id?: number;
  agency?: string;
  account?: string;
  balance?: number;
  password?: string;
  customer?: Customer;
}
