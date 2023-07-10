import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import { useState } from "react";
import { Account } from "../../../models/Account";

export function FormConfirmBalance() {
    const [account, setAccount] = useState<Account>({
      balance: 0,
    });
  
    function handleConfirm(e: React.FormEvent<HTMLFormElement>) {
      e.preventDefault();
    }
  
    return (
      <>
        <div className="ajust">
          <Container className="container_balance_form">
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
                  <Button variant="primary" type="submit" size="lg">
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