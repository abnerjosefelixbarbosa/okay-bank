import * as cpf from "validation-br/dist/cpf";
import { CustomerService } from "../services/CustomerService"
import { Customer, CustomerInterface } from "../types/Customer";

export class CustomerValidation implements CustomerInterface {
  private customerInterface!: CustomerInterface;

  setCustomerValidation(customerInterface: CustomerInterface) {
    this.customerInterface = customerInterface;
  }

  async loginByCpfAndPassword(data: Customer) {
    if (!cpf.validate(data.cpf!)) {
      throw new Error("CPF invalid");
    }

    this.setCustomerValidation(new CustomerService());
    const request = await this.customerInterface.loginByCpfAndPassword(data);
    return request;
  }
} 