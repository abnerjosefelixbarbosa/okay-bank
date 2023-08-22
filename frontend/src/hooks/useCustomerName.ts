import { useEffect, useState } from "react";
import { useProps } from "./useProps";

export function useCustomerName() {
    const [name, setName] = useState<string>("");
    const { account } = useProps();

    useEffect(() => {
      const list = account.customer?.name!.split(" ");
      if (list) 
        setName(list![0])
    });

    return {
      name: name
    }
}