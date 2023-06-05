import { Customer } from "./Customer";

export interface Address {
  id?: Number;
  number?: Number;
  zipCode?: String;
  address?: String;
  neighborhood?: String;
  city?: String;
  state?: String;
  customer?: Customer;
}
