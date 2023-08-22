import { createContext, useState } from "react";
import { Account } from "../../types/Account";

interface ProviderProps {
  children: React.ReactNode;
}

interface ContexProps {
  account: Account;
  updateAccount: (account: Account) => void;
  customerName: string;
  updateCustomerName: (name: string) => void;
}

export const MyContext = createContext({} as ContexProps);

export function Provider({ children } : ProviderProps) {
  const [account, setAccount] = useState<Account>({});
  const [customerName, setCustomerName] = useState<string>("");

  function updateAccount(account: Account) {
    setAccount(account);
  }

  function updateCustomerName(name: string) {
    setCustomerName(name);
  }

  return (
    <MyContext.Provider
      value={{
        account,
        updateAccount,
        customerName,
        updateCustomerName,
      }}
    >
      {children}
    </MyContext.Provider>
  );
}
