import { useEffect, useState } from "react";
import { useLocation } from "react-router-dom";
import { Account } from "../types/Account";
import { AccountService } from "../services/AccountService";

export function useAccounts() {
  const location = useLocation();
  const [accounts, setAccounts] = useState<Array<Account>>([]);
  const [accountService] = useState(new AccountService());

  useEffect(() => {
    accountService.getAllByCustomerId(location.state.id).then((data) => {
      setAccounts(data);
    });
  }, []);

  return { accounts };
}
