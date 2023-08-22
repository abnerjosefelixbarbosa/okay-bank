import { Customer } from "../types/Customer";
import { createContext, useState, useContext } from "react";
import { Account } from "./../types/Account";

interface ContexProps {
  customer: Customer;
  updateCustomer: (customer: Customer) => void;
  account: Account;
  updateAccount: (account: Account) => void;
}

interface ProviderProps {
  children: React.ReactNode;
}

export const MyContext = createContext({} as ContexProps);

export function Provider({ children }: ProviderProps) {
  const [customer, setCustomer] = useState<Customer>({});
  const [account, setAccount] = useState<Account>({});

  function updateCustomer(customer: Customer) {
    setCustomer(customer);
  }

  function updateAccount(account: Account) {
    setAccount(account);
  }

  return (
    <MyContext.Provider
      value={{
        customer,
        updateCustomer,
        account,
        updateAccount,
      }}
    >
      {children}
    </MyContext.Provider>
  );
}

export function useProps() {
  const context = useContext(MyContext);
  return context;
}
