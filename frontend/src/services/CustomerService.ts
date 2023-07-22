import { Customer } from "../models/Customer";
import { BASE_URL } from "../utils/Request";
import { loginByCpfAndPassword as validationLoginByCpfAndPassword } from "../utils/CustomerValidation";

export async function loginByCpfAndPassword(customer: Customer) {
  validationLoginByCpfAndPassword(customer);
  const request = await fetch(`${BASE_URL}/customers/login-by-cpf-and-password`, {
    method: "POST",
    headers: {
      "content-type": "application/json",
      "accept": "application/json",
    },
    body: JSON.stringify(customer),
  })
  .then((response) => response.json())
  .then((data) => data)
  .catch((e) => e);
  if (request.message) {
    throw new Error(request.message);
  }
  return request;
}