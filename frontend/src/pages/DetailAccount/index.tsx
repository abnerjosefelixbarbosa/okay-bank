import "./index.css";
import { NavbarDetailAccount } from "./NavbarDetailAccount";
import { CardDetailAccounts } from "./CardDetailAccount";
import { useAccount } from "../../hooks/useAccount";
import { useProps } from "../../hooks/useProps";
import { useEffect } from 'react';

export function DetailAccount() {
  const { account } = useAccount();
  const { updateAccount } = useProps();

  useEffect(() => {
    updateAccount(account);
  })
    
  return (
    <>
      <NavbarDetailAccount />
      <CardDetailAccounts  />
    </>
  );
}
