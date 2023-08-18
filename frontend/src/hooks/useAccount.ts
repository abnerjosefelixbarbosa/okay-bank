import { useEffect, useState } from "react";
import { useLocation } from "react-router-dom";
import { AccountValidation } from "../utils/AccountValidation";
import { Account } from "../types/Account";

export function useAccount() {
  const location = useLocation();
  const [accountValidation] = useState(new AccountValidation());
  const [account, setAccount] = useState<Account>({});

  useEffect(() => {
    accountValidation.getById(location.state.id).then((data) => {
      setAccount(data);
    });
  }, []);

  return {account}
}