import { Customer } from "../types/Customer";
import { createContext, useState, useContext } from "react";

interface ContexProps {
  customer: Customer;
  updateCustomer: (customer: Customer) => void;
}

interface ProviderProps {
  children: React.ReactNode;
}

export const MyContext = createContext({} as ContexProps);

export function Provider({ children }: ProviderProps) {
  const [customer, setCustomer] = useState<Customer>({});

  function updateCustomer(customer: Customer) {
    setCustomer(customer);
  }

  return (
    <MyContext.Provider
      value={{
        customer,
        updateCustomer,
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
