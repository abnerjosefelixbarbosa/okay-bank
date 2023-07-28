import * as cpf from "validation-br/dist/cpf";
import { DataLoginByCpfAndPassword } from "../types/DataLoginByCpfAndPassword";

export function loginByCpfAndPassword(data: DataLoginByCpfAndPassword) {
  if (!cpf.validate(data.cpf)) {
    throw new Error("CPF invalid");
  }
}
