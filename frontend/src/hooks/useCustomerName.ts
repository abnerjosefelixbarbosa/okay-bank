import { useEffect, useState } from "react";
import { Customer } from "../types/Customer";

export function useCustomerName(customer: Customer) {
    const [names, setNames] = useState<Array<string>>([]);

    useEffect(() => {
      if (customer) {
        setNames(customer.name!.split(" "));
      }
    });

    return {
      name: names[0]
    }
}