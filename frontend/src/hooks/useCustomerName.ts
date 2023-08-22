import { useEffect } from "react";
import { useProps } from "./useProps";

export function useCustomerName() {
    const { account, updateCustomerName } = useProps();

    useEffect(() => {
      const list = account.customer?.name!.split(" ");
      if (list) 
        updateCustomerName(list![0])
    });
}