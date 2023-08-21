import { useEffect, useState } from "react";
import { useLocation } from "react-router-dom";
import { Account } from "../types/Account";
import { AccountService } from "../services/AccountService";

export function useAccount() {
  const location = useLocation();
  const [accountService] = useState(new AccountService());
  const [account, setAccount] = useState<Account>({});

  useEffect(() => {
    accountService.getById(location.state.id).then((data) => {
      setAccount(data);
    });
  }, []);

  return { account };
}
