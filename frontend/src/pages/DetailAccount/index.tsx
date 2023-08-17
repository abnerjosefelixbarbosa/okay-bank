import { useLocation } from "react-router-dom";
import "./index.css";
import { useEffect, useState } from "react";
import { NavbarDetailAccount } from "./NavbarDetailAccount";
import { CardDetailAccounts } from "./CardDetailAccount";
import { AccountValidation } from "../../utils/AccountValidation";
import { Account } from "../../types/Account";

export function DetailAccount() {
  const location = useLocation(); 
  const [accountValidation] = useState(new AccountValidation());
  const [account, setAccount] = useState<Account | null>(null);

  useEffect(() => {
    accountValidation.getById(location.state.id)
    .then((data) => {
      setAccount(data)
    });
  }, []);

  return (
    <>
      <NavbarDetailAccount account={account!}  />
      <CardDetailAccounts
        account={account!}
      />
    </>
  );
}