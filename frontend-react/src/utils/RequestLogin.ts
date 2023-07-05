import { Customer } from "../models/Customer";
import { BASE_URL } from "./request";

export async function requestLogin(customer: Customer) {
  return await fetch(`${BASE_URL}/customers/login-by-cpf-and-password`, {
    method: "POST",
    headers: {
      "accept": "application/json",
      "content-type": "application/json",
    },
    body: JSON.stringify(customer),
  })
  .then((res) => res.json())
  .then((data) => {   
    const message: string = data.message;
    if (message !== "") {
      return message;
    }
    customer = { ...data }
    return customer; 
  })
  .catch((err) => {
    const message: string = err.message;
    if (message !== "") {
      return "Failed request"
    }
    return message;
  });
}
