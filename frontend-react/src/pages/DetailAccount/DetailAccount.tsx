import { useLocation } from "react-router-dom";
import { Account } from "../../models/entities/Account";
import "./style.css";
import { useState } from "react";
import { useEffect } from "react";
import { NavbarDetailAccount } from "./NavbarDetailAccount/NavbarDetailAccount";
import { CardDetailAccounts } from "./CardDetailAccount/CardDetailAccount";
import { getById } from '../../models/services/AccountService';

export function DetailAccount() {
  const location = useLocation();
  const [account, setAccount] = useState<Account>({});

  useEffect(() => {
    getById(location.state.id).then((data) => {
      if (typeof data === "object") {
        setAccount(data);
      }
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
