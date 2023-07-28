import { Customer } from "../types/Customer";
import { BASE_URL } from "../utils/Request";
import { DataLoginByCpfAndPassword } from "../types/DataLoginByCpfAndPassword";

export async function loginByCpfAndPassword(data: DataLoginByCpfAndPassword) {
  const request = await fetch(`${BASE_URL}/customers/login-by-cpf-and-password`, {
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
  const customer: Customer = { ...request }
  return customer;
}