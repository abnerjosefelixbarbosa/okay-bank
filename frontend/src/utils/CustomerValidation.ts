import * as cpf from "validation-br/dist/cpf";
import { CustomerService } from "../services/CustomerService"
import { Customer } from "../types/Customer";

interface ICustomer {
  loginByCpfAndPassword(data: Customer): Promise<any>;
}

export class CustomerValidation implements ICustomer {
  private iCustomer!: ICustomer;

  setCustomerValidation(iCustomer: ICustomer) {
    this.iCustomer = iCustomer;
  }

  async loginByCpfAndPassword(data: Customer): Promise<any> {
    if (!cpf.validate(data.cpf!)) {
      throw new Error("CPF invalid");
    }
    this.setCustomerValidation(new CustomerService());
    const request = await this.iCustomer.loginByCpfAndPassword(data);
    return request;
  }
} 