import { useLocation } from "react-router-dom";
import { Account } from "../../models/Account";
import { BASE_URL } from "../../utils/request";
import "./style.css";
import { useState } from "react";
import { useEffect } from "react";
import { NavbarDetailAccount } from "../../components/Navbar/NavbarDetailAccount";
import { Customer } from "./../../models/Customer";
import { CardDetailAccounts } from "../../components/Card/CardDetailAccounts";

async function requestGetById(id: string) {
  return await fetch(`${BASE_URL}/accounts/get-by-id/${id}`, {
    method: "GET",
    headers: {
      "content-type": "application/json",
    },
  })
    .then(async (response) => {
      const data = await response.json();
      const message: string = data.message;
      const account: Account = data;
      if (response.ok) {
        return account;
      }
      return message;
    })
    .then((data) => data)
    .catch(() => "Failure request");
}

export function DetailAccount() {
  const location = useLocation();
  const [account, setAccount] = useState<Account>({});

  useEffect(() => {
    requestGetById(location.state.id).then((data) => {
      if (typeof data === "object") {
        setAccount(data);
        return data.customer?.name;
      }
    });
  });

  return (
    <>
      <NavbarDetailAccount customer={account.customer} />
      <CardDetailAccounts
        account={account.account}
        agency={account.agency}
        balance={account.balance}
      />
    </>
  );
}
