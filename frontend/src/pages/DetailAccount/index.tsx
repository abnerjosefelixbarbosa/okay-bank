import { useLocation } from "react-router-dom";
import { Account } from "../../types/Account";
import "./index.css";
import { useState } from "react";
import { useEffect } from "react";
import { NavbarDetailAccount } from "./NavbarDetailAccount/NavbarDetailAccount";
import { CardDetailAccounts } from "./CardDetailAccount/CardDetailAccount";
import { AccountValidation } from "../../utils/AccountValidation";

export function DetailAccount() {
  const location = useLocation();
  const [account, setAccount] = useState<Account>();
  const [ accountValidation ] = useState<AccountValidation>(new AccountValidation())

  useEffect(() => {
    accountValidation.getById(location.state.id)
    .then((data) => {
      setAccount(data);
    })
  }, []);

  return (
    <>
      <NavbarDetailAccount
        agency={account!.agency.agency}
        account={account!.account}
        customerName={account!.customer.name}
        balance={account!.balance}
        password={account!.password}
        id={account!.id}
      />
      <CardDetailAccounts
        account={account!.account}
        agency={account!.agency.agency}
        balance={account!.balance}
      />
    </>
  );
}
