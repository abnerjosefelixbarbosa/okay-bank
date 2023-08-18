import { useEffect, useState } from "react";
import { Customer } from "../types/Customer";

export function useCustomerName(customer: Customer) {
    const [name, setName] = useState<string>("");

    useEffect(() => {
      if (customer) {
        const names: Array<string> = customer.name!.split(" ");
        setName(names[0]);
      }
    });

    return {name}
}