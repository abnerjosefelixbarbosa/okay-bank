import { BrowserRouter, Route, Routes } from "react-router-dom";
import { Login } from "../pages/Login/Login";
import { NoPage } from "../pages/NoPage/NoPage";
import { ApresentAccounts } from "../pages/ApresentAccounts/ApresentAccounts";

export function Router() {
  return (
    <BrowserRouter>
      <Routes>
        <Route index element={<Login />} />
        <Route path="/apresent-accounts" element={<ApresentAccounts />}/>
        <Route path="*" element={<NoPage />} />
      </Routes>
    </BrowserRouter>
  );
}
