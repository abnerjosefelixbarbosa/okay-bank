import { Account } from "../types/Account";
import { DatafindByAgencyAndAccount } from "../types/DatafindByAgencyAndAccount";
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
  const accounts: Account[] = [];
  request.forEach((data: Account) => {
    accounts.push(data);
  });
  return accounts
}

export async function findByAgencyAndAccount(data: DatafindByAgencyAndAccount) {
  const request = await fetch(`${BASE_URL}/accounts/find-by-agency-and-account`, {
    method: "POST",
    headers: {
      "content-type": "application/json",
      "accept": "application/json",
    },
    body: JSON.stringify({ ...data }),
  })
  .then((response) => response.json())
  .then((data) => data)
  .catch((e) => e);
  if (request.message) {
    throw new Error(request.message);
  }
  if (data.id === request.id) {
    throw new Error("account is logged");
  }
  const account: Account = { ...request }
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
  const account: Account = { ...request };
  return account;
}