import { Account } from "../models/Account";
import { BASE_URL } from "../utils/request";

export async function requestListAllById(id: string) {
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
