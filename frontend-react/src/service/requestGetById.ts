import { Account } from "../models/Account";
import { BASE_URL } from "../utils/request";

export async function requestGetById(id: string) {
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