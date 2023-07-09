import { Account } from "../models/Account";
import { BASE_URL } from "../utils/request";

export async function requestFindAccountAndAgency(account: Account) {
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
