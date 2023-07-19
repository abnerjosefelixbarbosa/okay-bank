import { Customer } from "../models/Customer";
import { BASE_URL } from "../utils/Request";

async function loginByCpfAndPassword(customer: Customer) {
  return await fetch(`${BASE_URL}/customers/login-by-cpf-and-password`, {
    method: "POST",
    headers: {
      "content-type": "application/json",
    },
    body: JSON.stringify(customer),
  })
    .then(async (response) => {
      const data = await response.json();
      if (!response.ok) {
        return data.message;
      }
      return data;
    })
    .catch(() => "Failure request");
}

export const CustomerService = {
  loginByCpfAndPassword,
}