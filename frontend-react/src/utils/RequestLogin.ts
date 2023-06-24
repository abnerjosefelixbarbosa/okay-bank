import { Customer } from "../models/Customer";
import { BASE_URL } from "./Request";

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

  if (res.status !== 200) {
    const err: string = json.message; 
    return err;
  }
  
  customer = { ...json }
  return customer ;
}
