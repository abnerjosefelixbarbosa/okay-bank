import { Account, AccountInterface } from "../types/Account";
import { BASE_URL } from "../utils/Request";

export class AccountService implements AccountInterface  {
  async getAllByCustomerId(id: string) {
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
    
    return request
  }
  
  async findByAgencyAndAccount(data: Account) {
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

    return request;  
  }
  
  async getById(id: string) {
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
} 