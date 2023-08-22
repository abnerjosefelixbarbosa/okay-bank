import { useEffect, useState } from "react";
import { Customer } from "../types/Customer";

export function useCustomerName(customer: Customer) {
    const [name, setName] = useState<string>("");

    useEffect(() => {
      if (customer) {
        const list = customer.name!.split(" ");
        setName(list[0])
      }
    });

    return {
      name: name
    }
}