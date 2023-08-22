import "./index.css";
import { NavbarDetailAccount } from "./NavbarDetailAccount";
import { CardDetailAccounts } from "./CardDetailAccount";
import { useAccount } from "../../hooks/useAccount";

export function DetailAccount() {
  useAccount();
    
  return (
    <>
      <NavbarDetailAccount />
      <CardDetailAccounts />
    </>
  );
}
