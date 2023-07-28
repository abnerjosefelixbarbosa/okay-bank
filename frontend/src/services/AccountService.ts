import { Account } from "../types/Account";
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

interface DatafindByAgencyAndAccount {
  id: string,
  agency: string,
  account: string
}

export async function findByAgencyAndAccount(data: DatafindByAgencyAndAccount) {
  const request = await fetch(`${BASE_URL}/accounts/find-by-agency-and-account`, {
    method: "POST",
    headers: {
      "content-type": "application/json",
      "accept": "application/json",
    },
    body: JSON.stringify({
      account: data.account,
      agencyAgency: data.agency,
    }),
  })
  .then((response) => response.json())
  .then((data) => data)
  .catch((e) => e);
  if (request.message) {
    throw new Error(request.message);
  }
  if (data.id === request.id) {
    throw new Error("id is equals");
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