import { Customer } from "../models/Customer";
import * as cpf from 'validation-br/dist/cpf';
import { CPFFormLoginError } from "./Exception";

function loginByCpfAndPassword(customer: Customer) {
    const customerCpf: any = customer.cpf;
    if (!cpf.validate(customerCpf)) {
        throw new CPFFormLoginError("CPF invalid");
    }
} 

export const CustomerValidation = {
    loginByCpfAndPassword
}