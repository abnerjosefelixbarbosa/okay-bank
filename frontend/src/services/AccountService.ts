import { Account } from "../models/Account";
import { BASE_URL } from "../utils/Request";

export async function listAllById(id: string) {
  const request = await fetch(`${BASE_URL}/accounts/list-all-by-id/${id}`, {
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
  return request
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