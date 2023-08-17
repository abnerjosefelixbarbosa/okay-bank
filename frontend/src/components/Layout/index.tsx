import { Outlet } from "react-router-dom";
import { Account } from "../../types/Account";
import { useState } from "react";

export function Layout() {
  const [account, setAccount] = useState<Account | null>(null);

  return (
    <div>
      <main>
        <Outlet context={[account, setAccount]}  />
      </main>
    </div>
  );
}