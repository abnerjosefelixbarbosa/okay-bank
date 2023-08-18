import { Customer, CustomerInterface } from "../types/Customer";
import { BASE_URL } from "../utils/Request";

export class CustomerService implements CustomerInterface {
  async loginByCpfAndPassword(data: Customer) {
    const request = await fetch(`${BASE_URL}/customers/login-by-cpf-and-password`, {
      method: "POST",
      headers: {
        "content-type": "application/json",
        "accept": "application/json",
      },
      body: JSON.stringify({...data}),
    })
    .then((response) => response.json())
    .then((data) => data)
    .catch((e) => e);
  
    if (request.message) {
      throw new Error(request.message);
    }
  
    return request;
  }
}