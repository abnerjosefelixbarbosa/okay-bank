import { Customer } from "../models/Customer";
import { BASE_URL } from "../utils/Request";

async function loginByCpfAndPassword(customer: Customer) {
  const request = await fetch(`${BASE_URL}/customers/login-by-cpf-and-password`, {
    method: "POST",
    headers: {
      "content-type": "application/json",
      "accept": "application/json",
    },
    body: JSON.stringify(customer),
  })
  .then((response) => response.json())
  .then((data) => data);

  return request;
}

export const CustomerService = {
  loginByCpfAndPassword,
};
