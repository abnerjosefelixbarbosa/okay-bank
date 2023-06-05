import axios from "axios";
import { Customer } from "../../models/Customer";
import { BASE_URL } from "../../utils/request";
import { Account } from "../../models/Account";

export const AccountService = () => {
  const loginByCpfAndPassword = async (customer: Customer) => {
    if (customer.cpf === "" || customer.cpf?.length !== 14) {
      throw new Error("cpf invalido");
    }

    if (customer.password === "" || customer.password?.length !== 6) {
      throw new Error("senha invalido");
    }

    return await axios
      .post(`${BASE_URL}/accounts/login-by-cpf-and-password`, customer)
      .then((response) => {
        const account: Account = { ...response.data };
        return account;
      })
      .catch((e) => {
        const mesage: string = e.response.data;
        throw new Error(mesage);
      });
  };

  const findByAgencyAndAccount = async (account: Account) => {
    if (account.agency === "") {
      throw new Error("agencia invalida");
    }

    if (account.account === "") {
      throw new Error("conta invalida");
    }

    return await axios
      .post(`${BASE_URL}/accounts/find-by-agency-and-account`, account)
      .then((response) => {
        account = { ...response.data };
        return account;
      })
      .catch((e) => {
        const mesage: string = e.response.data;
        throw new Error(mesage);
      });
  };

  const transferBalance = async (
    account1: Account,
    account2: Account,
    data: Account
  ) => {
    if (
      data.password === "" ||
      data.password?.length !== 4 ||
      data.password !== account1.password
    ) {
      throw new Error("senha invalida");
    }

    return await axios
      .put(
        `${BASE_URL}/accounts/transfer-balance/${account1.id}/${account2.id}`,
        data
      )
      .then((response) => {
        const mesage: string = { ...response.data };
        return mesage;
      })
      .catch((e) => {
        const mesage: string = e.response.data;
        throw new Error(mesage);
      });
  };

  return {
    loginByCpfAndPassword,
    findByAgencyAndAccount,
    transferBalance
  };
};
