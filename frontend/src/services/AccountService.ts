import { Account } from "../models/Account";
import { Agency } from "../models/Agency";
import { Customer } from "../models/Customer";
import { BASE_URL } from "../utils/Request";

interface DataGetAllByCustomerId {
  id: string,
  agency: string,
  account: string
}

export async function getAllByCustomerId(id: string) {
  const request = await fetch(`${BASE_URL}/accounts/get-all-by-customer-id/${id}`, {
    method: "GET",
    headers: {
      "content-type": "application/json",
      "accept": "application/json",
    },
  })
  .then((response) => response.json())
  .then((data) => data)
  .catch((e) => e);
  if (request.message) {
    throw new Error(request.message);
  }
  const agency: Agency = {};
  const account: Account = {};
  const accounts: Array<Account> = new Array<Account>();
  request.forEach((data: DataGetAllByCustomerId) => {
    account.id = data.id
    agency.agency = data.agency
    account.agency = agency
    account.account = data.account
    accounts.push(account);
  });
  return accounts
}

interface DatafindByAgencyAndAccount {
  agency?: string,
  account?: string
}

export async function findByAgencyAndAccount(data: DatafindByAgencyAndAccount) {
  const request = await fetch(`${BASE_URL}/accounts/find-by-agency-and-account`, {
    method: "POST",
    headers: {
      "content-type": "application/json",
      "accept": "application/json",
    },
    body: JSON.stringify({
      agency: data.agency,
      account: data.account,
    }),
  })
  .then((response) => response.json())
  .then((data) => data)
  .catch((e) => e);
  if (request.message) {
    throw new Error(request.message);
  }
  const account: Account = {}
  account.id = request.id
  return account;  
}

export async function getById(id: string) {
  const request = await fetch(`${BASE_URL}/accounts/get-by-id/${id}`, {
    method: "GET",
    headers: {
      "content-type": "application/json",
      "accept": "application/json",
    },
  })
  .then((response) => response.json())
  .then((data) => data)
  .catch((e) => e);
  if (request.message) {
    throw new Error(request.message);
  }
  const customer: Customer = {};
  const agency: Agency = {};
  const account: Account = {};
  customer.name = request.nameCustomer;
  agency.agency = request.agency;
  account.id = request.idAccount;
  account.account = request.account;
  account.balance = request.balance;
  account.agency = agency;
  account.customer = customer;
  return account;
}