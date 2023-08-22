import { Account } from "../types/Account";
import { 
  ACCOUNTS_TRANSFER_BALANCE,
  ACCOUNTS_FIND_BY_AGENCY_AND_ACCOUNT,
  ACCOUNTS_GET_BY_ID,
  ACCOUNTS_GET_ALL_BY_CUSTOMER_ID
} from "../utils/Request";

interface AccountInterface {
  getAllByCustomerId(id: string): Promise<Account[]>;
  findByAgencyAndAccount(data: Account): Promise<Account>;
  getById(id: string): Promise<Account>;
  transferBalance(
    id1: string,
    id2: string,
    balance: number,
  ): Promise<Account>;
}

export class AccountService implements AccountInterface  {

  validBalance(balance: number, currentBalance: number) {
    if (balance === 0)
      throw new Error("Balance is 0");
    if (balance > currentBalance)
      throw new Error("Balance is greater than current balance");
  }

  async getAllByCustomerId(id: string) {
    const request = await fetch(`${ACCOUNTS_GET_ALL_BY_CUSTOMER_ID}/${id}`, {
      method: "GET",
      headers: {
        "content-type": "application/json",
        "accept": "application/json",
      },
    })
    .then((response) => response.json())
    .then((data) => data)
    .catch((e) => e);
  
    if (request.message) 
      throw new Error(request.message);
    
    const accounts: Account[] = request
    return accounts;
  }
  
  async findByAgencyAndAccount(data: Account) {
    const request = await fetch(`${ACCOUNTS_FIND_BY_AGENCY_AND_ACCOUNT}`, {
      method: "POST",
      headers: {
        "content-type": "application/json",
        "accept": "application/json",
      },
      body: JSON.stringify({ 
        "agency": data.agency?.agency,
        "account": data.account,
      }),
    })
    .then((response) => response.json())
    .then((data) => data)
    .catch((e) => e);

    if (request.message) 
      throw new Error(request.message);

    if (request.id === data.id)
      throw new Error("Account logged in");

    const account: Account = { ...request }
    return account;
  }
  
  async getById(id: string) {
    const request = await fetch(`${ACCOUNTS_GET_BY_ID}/${id}`, {
      method: "GET",
      headers: {
        "content-type": "application/json",
        "accept": "application/json",
      },
    })
    .then((response) => response.json())
    .then((data) => data)
    .catch((e) => e);

    if (request.message)
      throw new Error(request.message);

    const account: Account = { ...request }
    return account;
  }

  async transferBalance(id1: string, id2: string, balance: number) {
    const request = await fetch(`${ACCOUNTS_TRANSFER_BALANCE}/${id1}/${id2}`, {
      method: "PUT",
      headers: {
        "content-type": "application/json",
        "accept": "application/json",
      },
      body: JSON.stringify({
        "balance": balance
      })
    })
    .then((response) => response.json())
    .then((data) => data)
    .catch((e) => e);

    if (request.message)
      throw new Error(request.message);

    const account: Account = { ...request }
    return account;
  }

} 