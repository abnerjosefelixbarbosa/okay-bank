import { useCallback, useEffect } from "react";
import { useProps } from "./useProps";

export function useCustomerName() {
    const { account, updateCustomerName } = useProps();

    const render = useCallback(() => {
      const list = account.customer?.name!.split(" ");
      if (list) 
        updateCustomerName(list![0])
    }, [updateCustomerName])

    useEffect(() => {
      render()
    }, [render]);
}