import { useLocation } from "react-router-dom";
import "./style.css";
import { FormConfirmTransfer } from "./FormConfirmTransfer/FormConfirmTransfer";

export function ConfirmTransfer() {
  const location = useLocation();

  return (
    <>
      <FormConfirmTransfer />
    </>
  );
}