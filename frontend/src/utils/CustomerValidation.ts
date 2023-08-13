import * as cpf from "validation-br/dist/cpf";
import { loginByCpfAndPassword as serviceLoginByCpfAndPassword } from "../services/CustomerService"
import { sleep } from "./SetTime";

interface DataLogin {
  cpf: string,
  password: string
}

export async function loginByCpfAndPassword(data: DataLogin) {
  if (!cpf.validate(data.cpf)) {
    throw new Error("CPF invalid");
  }

  const request = await serviceLoginByCpfAndPassword(data);
  await sleep(3000);
  return request;
}
