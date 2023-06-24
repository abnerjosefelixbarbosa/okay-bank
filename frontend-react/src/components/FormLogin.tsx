import "./style.css";
import Form from "react-bootstrap/Form";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Button from "react-bootstrap/Button";
import { useEffect, useState } from "react";
import { Customer } from "../models/Customer";
import { requestLogin } from "../utils/RequestLogin";

export default function FormLogin() {
  const [customer, setCustomer] = useState<Customer>({
    cpf: "",
    password: "",
  });
  const [clickLogin, setClickLogin] = useState<number>(0);

  useEffect(() => {
    requestLogin(customer)
      .then((response) => {
        console.log(response);
      })
      .catch((error) => {
        console.log(error);
      });
  }, [clickLogin]);

  return (
    <>
      <div className="ajust">
        <Container className="conteiner_login_form">
          <Form
            className="login_form"
            onSubmit={(e: React.FormEvent<HTMLFormElement>) => {
              e.preventDefault();
              setClickLogin(clickLogin + 1);
            }}
          >
            <Row className="center title_login_form">
              <h1>Okay Bank</h1>
            </Row>
            <Row>
              <Form.Group className="mb-3" controlId="cpf">
                <Form.Label>CPF:</Form.Label>
                <Form.Control
                  type="text"
                  placeholder="Enter CPF"
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
                  placeholder="Enter Password"
                  onChange={(e) => {
                    customer.password = e.target.value;
                    setCustomer(customer);
                  }}
                />
              </Form.Group>
            </Row>
            <Row className="center button_login_form">
              <Button type="submit" variant="primary">
                Login
              </Button>
            </Row>
          </Form>
        </Container>
      </div>
    </>
  );
}