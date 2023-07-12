import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import { useState } from "react";
import { Account } from "../../../models/Account";
import { useLocation } from "react-router-dom";
import Alert from "react-bootstrap/esm/Alert";

export function FormConfirmBalance() {
  const location = useLocation();
  const [account, setAccount] = useState<Account>({
    balance: 0,
  });
  const [showElement, setShowElement] = useState<boolean>(false);
  const [message, setMessage] = useState<string>("");

  function handleConfirm(e: React.FormEvent<HTMLFormElement>) {
    e.preventDefault();
    if (account.balance !== undefined) {
      if (account.balance > location.state.balance) {
        showMessage("Value greater than current balance");
      } else {
        hiderMessage();
      }
    }
  }

  function showMessage(message: string) {
    setMessage(message);
    setShowElement(true);
  }

  function hiderMessage() {
    setMessage("");
    setShowElement(false);
  }

  return (
    <>
      <div className="ajust">
        <Container className="container_balance_form">
          <Row>
            {showElement ? (
              <div>
                <Alert variant="danger">
                  <span>{message}</span>
                </Alert>
              </div>
            ) : null}
          </Row>
          <Row>
            <Form onSubmit={(e) => handleConfirm(e)}>
              <Form.Group className="mb-3">
                <Form.Label>Balance</Form.Label>
                <Form.Control
                  type="number"
                  step=".01"
                  onChange={(e) => {
                    account.balance = Number.parseFloat(e.target.value);
                    setAccount(account);
                  }}
                />
              </Form.Group>
              <div className="d-grid gap-2">
                <Button className="btn_confirm" type="submit" size="lg">
                  Confirm
                </Button>
              </div>
            </Form>
          </Row>
        </Container>
      </div>
    </>
  );
}
