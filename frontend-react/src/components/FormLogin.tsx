import "./style.css";
import Form from "react-bootstrap/Form";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Button from "react-bootstrap/Button";
import { useState } from "react";
import Customer from "../models/Customer";

export default function FormLogin() {
  const [customer, setCustomer] = useState<Customer>({});
  const [count, setCount] = useState<number>(0);

  return (
    <>
      <div className="ajust">
        <Container className="conteiner_login_form">
          <Form className="login_form" onSubmit={() => setCount(count + 1)}>
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
                    setCustomer({
                      cpf: e.target.value
                    });
                  }}
                />
              </Form.Group>
              <Form.Group className="mb-3" controlId="password">
                <Form.Label>Password:</Form.Label>
                <Form.Control
                  type="password"
                  placeholder="Enter Password"
                  onChange={(e) => {
                    setCustomer({
                      password: e.target.value,
                    });
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


function handLogin(customer: Customer) {
  console.log(customer)
}