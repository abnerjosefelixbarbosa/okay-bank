import { Customer } from "../models/Customer";
import { BASE_URL } from "../utils/Request";
import { loginByCpfAndPassword as validationLoginByCpfAndPassword } from "../utils/CustomerValidation";
import { Employee } from './../models/Employee';

interface DataloginByCpfAndPassword {
  cpf: string,
  password: string
}

export async function loginByCpfAndPassword(data: DataloginByCpfAndPassword) {
  validationLoginByCpfAndPassword(data);
  const request = await fetch(`${BASE_URL}/customers/login-by-cpf-and-password`, {
    method: "POST",
    headers: {
      "content-type": "application/json",
      "accept": "application/json",
    },
    body: JSON.stringify(data),
  })
  .then((response) => response.json())
  .then((data) => data)
  .catch((e) => e);
  if (request.message) {
    throw new Error(request.message);
  }
  const customer: Customer = {
    id: request.id,
  }
  return customer;
}