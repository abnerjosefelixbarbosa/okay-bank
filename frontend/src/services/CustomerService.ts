import * as cpf from "validation-br/dist/cpf";
import { Customer } from "../types/Customer";
import { CUSTOMERS_LOGIN_BY_CPF_AND_PASSWORD } from "../utils/Request";

interface CustomerInterface {
  loginByCpfAndPassword(data: Customer): Promise<Customer>;
}

export class CustomerService implements CustomerInterface {

  validCpf(data: Customer) {
    if (!cpf.validate(data.cpf!)) 
      throw new Error("CPF invalid");
  }

  async loginByCpfAndPassword(data: Customer) {
    const request = await fetch(`${CUSTOMERS_LOGIN_BY_CPF_AND_PASSWORD}`, {
      method: "POST",
      headers: {
        "content-type": "application/json",
        "accept": "application/json",
      },
      body: JSON.stringify({
        "cpf": data.cpf,
        "password": data.password,
      }),
    })
    .then((response) => response.json())
    .then((data) => data)
    .catch((e) => e);
  
    if (request.message) 
      throw new Error(request.message);

    const customer: Customer = { ...request }
    return customer;
  }
}