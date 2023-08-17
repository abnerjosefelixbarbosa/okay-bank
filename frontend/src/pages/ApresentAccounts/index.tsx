import { useLocation } from "react-router-dom";
import { ListApresentAccounts } from "./ListApresentAccounts";
import "./index.css";
import { Account } from "../../types/Account";
import { AccountValidation } from "../../utils/AccountValidation";
import { useEffect, useState } from "react";

export function ApresentAccounts() {
  const location = useLocation();
  const [accounts, setAccounts] = useState<Array<Account>>([]);
  const [accountValidation] = useState(new AccountValidation());

  useEffect(() => {
    accountValidation.getAllByCustomerId(location.state.id).then((data) => {
      setAccounts(data);
    });
  }, []);


  return (
    <>
      <ListApresentAccounts accounts={accounts}/>
    </>
  );
}
