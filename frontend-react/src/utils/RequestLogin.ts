import { Customer } from "../models/Customer";
import { BASE_URL } from "./request";

export async function requestLogin(customer: Customer) {
  const init: RequestInit = {
    method: "POST",
    headers: {
      "accept": "application/json",
      "content-type": "application/json",
    },
    body: JSON.stringify(customer),
  };
  

  const res = await fetch(
    `${BASE_URL}/customers/login-by-cpf-and-password`,
    init
  );
  const json = await res.json();

  if (!res.ok) {
    const message: string = json.message;
    return message;
  } 

  customer = { ...json }
  return customer;
}
