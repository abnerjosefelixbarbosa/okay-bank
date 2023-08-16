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
  const accountValidation = new AccountValidation();

  useEffect(() => {
    accountValidation.getById(location.state.id)
    .then((data) => {
      setAccount({...data});
    })
  }, []);

  return (
    <>
      <NavbarDetailAccount
        account={account!}
        agency={account!.agency}
      />
      <CardDetailAccounts
        account={account!}
        agency={account!.agency}
      />
    </>
  );
}
