import { useLocation } from "react-router-dom";
import { Account } from "../../models/Account";
import "./style.css";
import { useState } from "react";
import { useEffect } from "react";
import { NavbarDetailAccount } from "./NavbarDetailAccount/NavbarDetailAccount";
import { CardDetailAccounts } from "./CardDetailAccount/CardDetailAccount";
import { requestGetById } from "../../service/requestGetById";

export function DetailAccount() {
  const location = useLocation();
  const [account, setAccount] = useState<Account>({});

  useEffect(() => {
    requestGetById(location.state.id).then((data) => {
      if (typeof data === "object") {
        setAccount(data);
        return data.customer?.name;
      }
    });
  });

  return (
    <>
      <NavbarDetailAccount
        agency={account.agency}
        account={account.account}
        customer={account.customer}
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
