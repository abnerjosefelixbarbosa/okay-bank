import { useEffect, useState } from "react";
import { Account } from "../types/Account";

export function useCustomerName(account: Account) {
    const [name, setName] = useState<string>("");

    useEffect(() => {
      if (account) {
        const names: Array<string> = account.customer.name.split(" ");
        setName(names[0]);
      }
    });

    return {name}
}