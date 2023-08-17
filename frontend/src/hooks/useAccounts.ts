import { useEffect, useState } from "react";
import { useLocation } from "react-router-dom";
import { Account } from "../types/Account";
import { AccountValidation } from "../utils/AccountValidation";

export function useAccounts() {
    const location = useLocation();
    const [accounts, setAccounts] = useState<Array<Account>>([]);
    const [accountValidation] = useState(new AccountValidation());
  
    useEffect(() => {
      accountValidation.getAllByCustomerId(location.state.id).then((data) => {
        setAccounts(data);
      });
    }, []);

    return {accounts}
}