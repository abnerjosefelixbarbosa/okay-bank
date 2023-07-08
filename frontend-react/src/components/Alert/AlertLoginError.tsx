import Alert from "react-bootstrap/esm/Alert";

interface PropsAlert {
  message?: string;
}

export function AlertLoginError({ message }: PropsAlert) {
    return (
      <Alert variant="danger">
        <span>{message}</span>
      </Alert>
    );
  }