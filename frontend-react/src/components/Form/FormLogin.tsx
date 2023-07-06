import Form from "react-bootstrap/Form";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import { useState } from "react";
import { Customer } from "../../models/Customer";
import { ButtonLogin } from "../Button/ButtonLogin";
import { IMaskInput } from "react-imask";
import { AlertLoginError } from "../Alert/AlertLoginError";
import Col from "react-bootstrap/esm/Col";
import { BASE_URL } from "../../utils/request";
import { useNavigate } from "react-router-dom";

async function request(customer: Customer) {
  return await fetch(`${BASE_URL}/customers/login-by-cpf-and-password`, {
    method: "POST",
    headers: {
      "content-type": "application/json",
    },
    body: JSON.stringify(customer),
  })
    .then(async (response) => {
      const data = await response.json();
      const message: string = data.message;
      const customer: Customer = { ...data };
      if (response.ok) {
        return customer
      }
      return message;
    })
    .then((data) => data)
    .catch(() => "Failure request");
}

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
    request(customer)
      .then((data) => {
        if (typeof data === "string") {
          showMessage(data);
        } else {
          hiderMessage();
          navigate("/apresent-accounts", {
            state: {
              "id": data.id,
            },
            replace: true
          })
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
        <Container className="conteiner_login_form">
          <Row>
            <Col className="conteiner_login_haeder">
              {showElement ? (
                <div>
                  <AlertLoginError message={message} />
                </div>
              ) : null}
            </Col>
          </Row>
          <Row>
            <Form
              className="login_form"
              onSubmit={(e: React.FormEvent<HTMLFormElement>) => {
                handleLogin(e);
              }}
            >
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
              </Row>
              <Row className="center button_login_form">
                <div className="d-grid gap-2">
                  <ButtonLogin />
                </div>
              </Row>
            </Form>
          </Row>
        </Container>
      </div>
    </>
  );
}
