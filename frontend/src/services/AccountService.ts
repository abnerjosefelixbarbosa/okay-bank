import { Account } from "../models/Account";
import { Agency } from "../models/Agency";
import { Customer } from "../models/Customer";
import { BASE_URL } from "../utils/Request";

interface DataGetAllByCustomerId {
  id: string,
  account: string,
  agencyAgency: string,
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
  const accounts: Account[] = [];
  request.forEach((data: DataGetAllByCustomerId) => {
    const agency: Agency = {
      agency: data.agencyAgency
    };
    const account: Account = {
      id: data.id,
      account: data.account,
      agency: agency
    };
    accounts.push(account);
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
  const account: Account = {
    id: request.id
  }
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
  const customer: Customer = {
    name: request.customerName,
  };
  const agency: Agency = {
    agency: request.agencyAgency
  };
  const account: Account = {
    id: request.id,
    account: request.account,
    balance: request.balance,
    agency: agency,
    customer: customer,
  };
  return account;
}