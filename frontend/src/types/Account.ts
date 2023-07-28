import { Agency } from "./Agency";
import { Customer } from "./Customer";
import { Employee } from "./Employee";

export interface Account {
  id: string;
  account: string;
  password: string;
  balance: number;
  employee: Employee;
  agency: Agency;
  customer: Customer;
}