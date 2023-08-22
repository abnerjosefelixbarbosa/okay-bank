import { useEffect, useState } from "react";
import { useLocation } from "react-router-dom";
import { AccountService } from "../services/AccountService";
import { useProps } from "./useProps";

export function useAccount() {
  const location = useLocation();
  const [accountService] = useState(new AccountService());
  const { updateAccount } = useProps();

  useEffect(() => {
    accountService.getById(location.state.id).then((data) => {
      updateAccount(data)
    });
  }, []);
}
