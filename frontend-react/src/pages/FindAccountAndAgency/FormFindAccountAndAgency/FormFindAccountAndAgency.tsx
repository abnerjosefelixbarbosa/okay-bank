import { useLocation, useNavigate } from "react-router-dom";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import { IMaskInput } from "react-imask";
import { useState } from "react";
import { Account } from "../../../models/Account";
import { Agency } from "../../../models/Agency";
import Alert from "react-bootstrap/Alert";
import Col from "react-bootstrap/Col";
import { requestFindAccountAndAgency } from "../../../service/requestFindAccountAndAgency";

export function FormFindAccountAndAgency() {
  const location = useLocation();
  const navigate = useNavigate();
  const [showElement, setShowElement] = useState<boolean>(false);
  const [message, setMessage] = useState<string>("");
  const [agency, setAgency] = useState<Agency>({
    agency: "",
  });
  const [account, setAccount] = useState<Account>({
    account: "",
    agency: agency,
  });

  function handleFind() {
    requestFindAccountAndAgency(account).then((data) => {
      if (typeof data === "string") {
        showMessage(data);
      } else {
        hiderMessage();
        navigate("/confirme-balance", {
          state: {
            "id1": location.state.id,
            "id2": data.id
          }  
        });
      }
    });
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
    <div className="ajust">
      <Container className="container_find_form">
        <Row>
          <Col>
            {showElement ? (
              <div>
                <Alert variant="danger">{message}</Alert>
              </div>
            ) : null}
          </Col>
        </Row>
        <Row>
          <Form
            onSubmit={(e) => {
              e.preventDefault();
              handleFind();
            }}
          >
            <Form.Group className="mb-3">
              <Form.Label>Agency</Form.Label>
              <Form.Control
                type="text"
                as={IMaskInput}
                mask="0000000000"
                onChange={(e) => {
                  agency.agency = e.target.value;
                  setAgency(agency);
                }}
              />
            </Form.Group>
            <Form.Group className="mb-3">
              <Form.Label>Account</Form.Label>
              <Form.Control
                type="text"
                as={IMaskInput}
                mask="0000000000"
                onChange={(e) => {
                  account.account = e.target.value;
                  setAccount(account);
                }}
              />
            </Form.Group>
            <div className="d-grid gap-2">
              <Button className="button_find" type="submit" size="lg">
                Find
              </Button>
            </div>
          </Form>
        </Row>
      </Container>
    </div>
  );
}
