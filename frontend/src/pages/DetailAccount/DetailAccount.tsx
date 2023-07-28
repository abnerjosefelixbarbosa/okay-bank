import { useLocation } from "react-router-dom";
import { Account } from "../../types/Account";
import "./style.css";
import { useState } from "react";
import { useEffect } from "react";
import { NavbarDetailAccount } from "./NavbarDetailAccount/NavbarDetailAccount";
import { CardDetailAccounts } from "./CardDetailAccount/CardDetailAccount";
import { getById as serviceGetById } from '../../services/AccountService';
import { Customer } from "../../types/Customer";
import { Agency } from "../../types/Agency";

export function DetailAccount() {
  const location = useLocation();
  const [account, setAccount] = useState<Account>({});

  useEffect(() => {
    serviceGetById(location.state.id)
    .then((data) => setAccount(data));
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
