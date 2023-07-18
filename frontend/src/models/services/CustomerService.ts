import { Customer } from "../entities/Customer";
import { BASE_URL } from "../../utils/Request";

export async function loginByCpfAndPassword(customer: Customer) {
  return await fetch(`${BASE_URL}/customers/login-by-cpf-and-password`, {
    method: "POST",
    headers: {
      "content-type": "application/json",
    },
    body: JSON.stringify(customer),
  })
    .then(async (response) => {
      const data = await response.json();
      const message: string = data.message;
      const customer: Customer = { ...data };
      if (response.ok) {
        return customer;
      }
      return message;
    })
    .then((data) => data)
    .catch(() => "Failure request");
}
