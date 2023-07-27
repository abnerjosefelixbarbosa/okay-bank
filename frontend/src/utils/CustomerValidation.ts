import * as cpf from "validation-br/dist/cpf";

interface DataLoginByCpfAndPassword {
  cpf: string;
  password: string;
}

export function loginByCpfAndPassword(data: DataLoginByCpfAndPassword) {
  if (cpf.validate(data.cpf)) {
    throw new Error("CPF invalid");
  }
}
