import { BrowserRouter, Route, Routes } from "react-router-dom";
import { Login } from "../pages/Login/Login";
import { ApresentAccounts } from "../pages/ApresentAccounts/ApresentAccounts";
import { DetailAccount } from "../pages/DetailAccount/DetailAccount";
import { FindAccountAndAgency } from "../pages/FindAccountAndAgency/FindAccountAndAgency";
import { ConfirmBalance } from "../pages/ConfirmBalance/ConfirmBalance";
import { ConfirmTransfer } from "../pages/ConfirmTransfer/ConfirmTransfer";
import { Layout } from "../components/Layout";

export function Router() {
  return (
    <BrowserRouter>
      <Routes>
        <Route element={<Layout />}>
          <Route index element={<Login />} />
          <Route path="/apresent-accounts" element={<ApresentAccounts />} />
          <Route path="/detail-account" element={<DetailAccount />} />
          <Route
            path="/find-account-and-agency"
            element={<FindAccountAndAgency />}
          />
          <Route path="/confirm-balance" element={<ConfirmBalance />} />
          <Route path="/confirm-transfer" element={<ConfirmTransfer />} />
          <Route path="*" element={<h1>Page does not exist.</h1>} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}
