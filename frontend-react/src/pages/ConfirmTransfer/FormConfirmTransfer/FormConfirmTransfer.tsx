import Button from "react-bootstrap/Button";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Form from "react-bootstrap/Form";
import { useState } from "react";
import { Account } from "../../../models/entities/Account";
import { IMaskInput } from "react-imask";

export function FormConfirmTransfer() {
  const [account, setAccount] = useState<Account>({
    password: "",
  });

  function handleConfirm(e: React.FormEvent<HTMLFormElement>) {
    e.preventDefault();
  }

  return (
    <>
      <div className="ajust">
        <Container className="container_transfer_form">
          <Row></Row>
          <Row>
            <Form onSubmit={(e) => handleConfirm(e)}>
              <Form.Group className="mb-3">
                <Form.Label>Password</Form.Label>
                <Form.Control
                  type="password"
                  as={IMaskInput}
                  mask={"0000"}
                  onChange={(e) => {
                    account.password = e.target.value;
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
