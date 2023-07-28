import * as cpf from "validation-br/dist/cpf";
import { DataLoginByCpfAndPassword } from "../types/DataLoginByCpfAndPassword";
import { loginByCpfAndPassword as serviceLoginByCpfAndPassword } from "../services/CustomerService"

export async function loginByCpfAndPassword(data: DataLoginByCpfAndPassword) {
  if (!cpf.validate(data.cpf)) {
    throw new Error("CPF invalid");
  }
  const request = await serviceLoginByCpfAndPassword(data);
  return request;
}
