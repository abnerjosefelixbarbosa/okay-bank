import { BrowserRouter, Route, Routes } from "react-router-dom";
import { Login } from "./pages/Login";
import { ApresentAccounts } from "./pages/ApresentAccounts";
import { DetailAccount } from "./pages/DetailAccount";
import { FindAccountAndAgency } from "./pages/FindAccountAndAgency";
import { ConfirmBalance } from "./pages/ConfirmBalance";
import { ConfirmTransfer } from "./pages/ConfirmTransfer";
import { Layout } from "./components/Layout";

export function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Layout />}>
            <Route index element={<Login />} />
            <Route path="/apresent-accounts" element={<ApresentAccounts />} />
            <Route path="/detail-account" element={<DetailAccount />} />
            <Route
              path="/find-account-and-agency"
              element={<FindAccountAndAgency />}
            />
            <Route path="/confirm-balance" element={<ConfirmBalance />} />
            <Route path="/confirm-transfer" element={<ConfirmTransfer />} />
          </Route>
          <Route path="*" element={<h1>Page does not exist.</h1>} />
        </Routes>
      </BrowserRouter>
    </>
  );
}
