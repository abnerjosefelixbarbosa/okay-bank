import { BrowserRouter, Route, Routes } from "react-router-dom";
import { Login } from "../pages/Login/Login";
import { NoPage } from "../pages/NoPage/NoPage";
import { ApresentAccounts } from "../pages/ApresentAccounts/ApresentAccounts";
import { DetailAccount } from "../pages/DetailAccount/DetailAccount";
import { FindAccountAndAgency } from "../pages/FindAccountAndAgency/FindAccountAndAgency";
import { ConfirmeBalance } from "../pages/ConfirmeBalance/ConfirmeBalance";

export function Router() {
  return (
    <BrowserRouter>
      <Routes>
        <Route index element={<Login />} />
        <Route path="/apresent-accounts" element={<ApresentAccounts />}/>
        <Route path="/detail-account" element={<DetailAccount />}/>
        <Route path="/find-account-and-agency" element={<FindAccountAndAgency />} />
        <Route path="/confirme-balance" element={<ConfirmeBalance />} />
        <Route path="*" element={<NoPage />} />
      </Routes>
    </BrowserRouter>
  );
}
