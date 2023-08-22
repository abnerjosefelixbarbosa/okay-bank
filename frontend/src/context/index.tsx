import { createContext, useState } from "react";
import { Account } from "../types/Account";

interface ProviderProps {
  children: React.ReactNode;
}

interface ContexProps {
  account: Account;
  updateAccount: (account: Account) => void;
}

export const MyContext = createContext({} as ContexProps);

export function Provider({ children } : ProviderProps) {
  const [account, setAccount] = useState<Account>({});

  function updateAccount(account: Account) {
    setAccount(account);
  }

  return (
    <MyContext.Provider
      value={{
        account,
        updateAccount,
      }}
    >
      {children}
    </MyContext.Provider>
  );
}
