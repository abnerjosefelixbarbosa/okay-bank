import Form from "react-bootstrap/Form";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import { useState } from "react";
import { Customer } from "../../../models/Customer";
import { IMaskInput } from "react-imask";
import Col from "react-bootstrap/esm/Col";
import { useNavigate } from "react-router-dom";
import Button from "react-bootstrap/Button";
import Alert from "react-bootstrap/Alert";
import { CustomerService } from "../../../services/CustomerService";

export function FormLogin() {
  const [customer, setCustomer] = useState<Customer>({
    cpf: "",
    password: "",
  });
  const [showElement, setShowElement] = useState<boolean>(false);
  const [message, setMessage] = useState<string>("");
  const navigate = useNavigate();

  function handleLogin(e: React.FormEvent<HTMLFormElement>) {
    e.preventDefault();
    const customerService = new CustomerService();
    customerService.loginByCpfAndPassword(customer).then((data) => {
      if (typeof data === "string") {
        showMessage(data);
      } else {
        hiderMessage();
        navigate("/apresent-accounts", {
          state: {
            id: data.id,
          },
          replace: true,
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
    <>
      <div className="ajust">
        <Container className="container_login_form">
          <Row>
            <Col className="container_login_haeder">
              {showElement ? (
                <div>
                  <Alert variant="danger">
                    <span>{message}</span>
                  </Alert>
                </div>
              ) : null}
            </Col>
          </Row>
          <Row>
            <Form className="login_form" onSubmit={handleLogin}>
              <Row className="title_login_form">
                <h1>Okay Bank</h1>
              </Row>
              <Row className="body_login_form">
                <Form.Group className="mb-3" controlId="cpf">
                  <Form.Label>CPF:</Form.Label>
                  <Form.Control
                    type="text"
                    as={IMaskInput}
                    mask="000.000.000-00"
                    onChange={(e) => {
                      customer.cpf = e.target.value;
                      setCustomer(customer);
                    }}
                  />
                </Form.Group>
                <Form.Group className="mb-3" controlId="password">
                  <Form.Label>Password:</Form.Label>
                  <Form.Control
                    type="password"
                    as={IMaskInput}
                    mask="000000"
                    onChange={(e) => {
                      customer.password = e.target.value;
                      setCustomer(customer);
                    }}
                  />
                </Form.Group>
                <div className="d-grid gap-2">
                  <Button className="button_login" type="submit" size="lg">
                    Login
                  </Button>
                </div>
              </Row>
            </Form>
          </Row>
        </Container>
      </div>
    </>
  );
}
