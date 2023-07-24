import { useLocation } from "react-router-dom";
import { Account } from "../../models/Account";
import "./style.css";
import { useState } from "react";
import { useEffect } from "react";
import { NavbarDetailAccount } from "./NavbarDetailAccount/NavbarDetailAccount";
import { CardDetailAccounts } from "./CardDetailAccount/CardDetailAccount";
import { getById as serviceGetById } from '../../services/AccountService';
import { Customer } from "../../models/Customer";
import { Agency } from "../../models/Agency";

export function DetailAccount() {
  const location = useLocation();
  const [account, setAccount] = useState<Account>({});

  useEffect(() => {
    serviceGetById(location.state.id)
    .then((data) => {
      const customer: Customer = {
        name: data.nameCustomer
      };
      const agency: Agency = {
        agency: data.agency
      };
      setAccount({
        id: data.idAccount,
        account: data.account,
        balance: data.balance,
        customer: customer,
        agency: agency
      });
    });
  }, [setAccount]);

  return (
    <>
      <NavbarDetailAccount
        agency={account.agency}
        account={account.account}
        customer={account.customer}
        balance={account.balance}
        password={account.password}
        id={account.id}
      />
      <CardDetailAccounts
        account={account.account}
        agency={account.agency}
        balance={account.balance}
      />
    </>
  );
}
