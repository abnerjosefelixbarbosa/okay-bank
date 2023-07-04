import Alert from "react-bootstrap/esm/Alert";
import { PropsAlert } from "../../utils/propsAlert";

export function AlertLoginError({ message }: PropsAlert) {
    return (
      <Alert variant="danger">
        <span>{message}</span>
      </Alert>
    );
  }