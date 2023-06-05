import { BrowserRouter, Route, Routes } from "react-router-dom";
import { Login } from "../pages/Login/Login";
import { NoPage } from "../pages/NoPage/NoPage";
import { Selection } from "../pages/Selection/Selection";
import { FindAccount } from "../pages/FindAccount/FindAccount";
import { Transfer } from "../pages/Transfer/Transfer";
import { ConfirmAccount } from "../pages/ConfirmAccount/ConfirmAccount";

export const Router = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route index element={<Login />} />
        <Route path="selection" element={<Selection />}/>
        <Route path="find-account" element={<FindAccount />} />
        <Route path="transfer" element={<Transfer />} />
        <Route path="confirm-account" element={<ConfirmAccount />} />
        <Route path="*" element={<NoPage />} />
      </Routes>
    </BrowserRouter>
  );
};
