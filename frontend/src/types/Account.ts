import { Agency } from "./Agency";
import { Customer } from "./Customer";
import { Employee } from "./Employee";
export interface Account {
  id?: string;
  account?: string;
  password?: string;
  balance?: number;
  employee?: Employee;
  agency?: Agency;
  customer?: Customer;
}

export interface AccountInterface {
  getAllByCustomerId(id: string): Promise<Account[]>;
  findByAgencyAndAccount(data: Account): Promise<Account>;
  getById(id: string): Promise<Account>;
  transferBalance(
    id1: string,
    id2: string,
    balance: number,
  ): Promise<Account>;
}
