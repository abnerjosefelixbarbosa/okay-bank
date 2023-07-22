import { Customer } from "../models/Customer";
import * as cpf from 'validation-br/dist/cpf';

export function loginByCpfAndPassword(customer: Customer) {
    const customerCpf: any = customer.cpf;
    if (!cpf.validate(customerCpf)) {
        throw new Error("CPF invalid");
    }
} 