import Form from "react-bootstrap/Form";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import { useState } from "react";
import { Customer } from "../../models/Customer";
import { requestLogin } from "../../utils/requestLogin";
import { ButtonLogin } from "../Button/ButtonLogin";
import { IMaskInput } from 'react-imask';

export function FormLogin() {
  const [customer, setCustomer] = useState<Customer>({
    cpf: "",
    password: "",
  });

  function onLogin(e: React.FormEvent<HTMLFormElement>) {
    e.preventDefault();
    console.log(customer);
    requestLogin(customer)
      .then((response) => {
        console.log(response);
      })
      .catch(() => {
        console.log("Failed request");
      });
  }

  return (
    <>
      <div className="ajust">
        <Container className="conteiner_login_form">
          <Form
            className="login_form"
            onSubmit={(e: React.FormEvent<HTMLFormElement>) => {
              onLogin(e);
            }}
          >
            <Row className="title_login_form">
              <h1>Okay Bank</h1>
            </Row>
            <Row>
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
        </Container>
      </div>
    </>
  );
}
