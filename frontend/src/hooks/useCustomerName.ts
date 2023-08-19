import { useEffect, useState } from "react";
import { Customer } from "../types/Customer";

export function useCustomerName(customer: Customer) {
    const [name, setName] = useState<string>("");

    useEffect(() => {
      if (customer) {
        setName(customer.name!);
      }
    });

    return {
      name: name.substring(0, 2)
    }
}