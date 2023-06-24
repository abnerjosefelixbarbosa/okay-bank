import { BrowserRouter, Route, Routes } from "react-router-dom"
import Login from "../pages/Login/Login";
import NoPage from "../pages/NoPage/NoPage";

export function Router() {
    return (
        <BrowserRouter>
        <Routes>
            <Route index element={<Login />} />
            <Route path="*" element={<NoPage />} />
        </Routes>
        </BrowserRouter>
    );
}