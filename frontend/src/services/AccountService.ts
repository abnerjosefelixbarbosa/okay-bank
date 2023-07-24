import { Account } from "../models/Account";
import { Agency } from "../models/Agency";
import { BASE_URL } from "../utils/Request";

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
  const newAgency: Agency = {};
  const newAccount: Account = {};
  const accounts: Array<Account> = new Array<Account>();
  request.forEach((val: any) => {
    newAccount.id = val.id
    newAgency.agency = val.agency
    newAccount.agency = newAgency
    newAccount.account = val.account
    accounts.push(newAccount);
  });
  return accounts
}

export async function findByAgencyAndAccount(account: Account) {
  const request = await fetch(`${BASE_URL}/accounts/find-by-agency-and-account`, {
    method: "POST",
    headers: {
      "content-type": "application/json",
      "accept": "application/json",
    },
    body: JSON.stringify({
      agency: account.agency?.agency,
      account: account.account,
    }),
  })
  .then((response) => response.json())
  .then((data) => data)
  .catch((e) => e);
  if (request.message) {
    throw new Error(request.message);
  }
  return request;  
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
  return request;
}