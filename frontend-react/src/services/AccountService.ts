import { Account } from "../models/Account";
import { BASE_URL } from "../utils/Request";

export class AccountService {
    async listAllById(id: string) {
        return await fetch(`${BASE_URL}/accounts/list-all-by-id/${id}`, {
            method: "GET",
            headers: {
              "content-type": "application/json",
            },
          })
            .then((response) => response.json())
            .then((data) => {
              const accounts: Array<Account> = [];
              accounts.push(...data);
              return accounts;
            })
            .catch(() => "Failure request");
    }

    async findByAgencyAndAccount(account: Account) {
      return await fetch(`${BASE_URL}/accounts/find-by-agency-and-account`, {
        method: "POST",
        headers: {
          "content-type": "application/json",
        },
        body: JSON.stringify({
          agency: account.agency?.agency,
          account: account.account,
        }),
      })
        .then(async (response) => {
          const data = await response.json();
          const message: string = data.message;
          account = { ...data };
          if (response.ok) {
            return account;
          }
          return message;
        })
        .then((data) => data)
        .catch(() => "Failure request");
    }

    async getById(id: string) {
      return await fetch(`${BASE_URL}/accounts/get-by-id/${id}`, {
        method: "GET",
        headers: {
          "content-type": "application/json",
        },
      })
        .then(async (response) => {
          const data = await response.json();
          const message: string = data.message;
          const account: Account = data;
          if (response.ok) {
            return account;
          }
          return message;
        })
        .then((data) => data)
        .catch(() => "Failure request");
    }
}