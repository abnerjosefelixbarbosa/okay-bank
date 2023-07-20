import Form from "react-bootstrap/Form";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import { useState } from "react";
import Col from "react-bootstrap/Col";
import { useNavigate } from "react-router-dom";
import { useForm } from "react-hook-form";
import Button from "react-bootstrap/Button";
import Alert from "react-bootstrap/Alert";
import { z } from "zod";
import { zodResolver } from "@hookform/resolvers/zod";

const schema = z.object({
  cpf: z.string()
  .regex((/^\d{3}\.\d{3}\.\d{3}-\d{2}$/), "cpf invalid"),
  password: z.string()
  .regex(/^\d{6}$/, "password invalid"),
});

type FormProps = z.infer<typeof schema>;

export function FormLogin() {
  const [showElement, setShowElement] = useState<boolean>(false);
  const [message, setMessage] = useState<string>("");
  const navigate = useNavigate();
  const {
    register,
    handleSubmit,
    formState: { errors, isSubmitting, isValid },
  } = useForm<FormProps>({
    mode: "all",
    reValidateMode: "onChange",
    resolver: zodResolver(schema),
  });

  function handleLogin(data: FormProps) {
    console.log(data);
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
            <Form className="login_form" onSubmit={handleSubmit(handleLogin)}>
              <Row className="title_login_form">
                <h1>Okay Bank</h1>
              </Row>
              <Row className="body_login_form">
                <Form.Group className="mb-3" controlId="cpf">
                  <Form.Label>CPF:</Form.Label>
                  <Form.Control
                    type="text" { ...register("cpf") }
                    onChange={(e) => {
                      let value = e.target.value;
                      value = value.replace(/(\D)/g, "");
                      if (value.length > 11) {
                        value = value.substring(0, 11)
                      }
                      value = value.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/g, "$1.$2.$3-$4");
                      e.target.value = value;
                    }}
                  />
                  <Form.Text className="text-muted">
                    {errors.cpf?.message}
                  </Form.Text>
                </Form.Group>
                <Form.Group className="mb-3" controlId="password">
                  <Form.Label>Password:</Form.Label>
                  <Form.Control
                    type="password"
                    {...register("password")}
                    onChange={(e) => {
                      let value = e.target.value;
                      value = value.replace(/(\D)/g, ""); 
                      if (value.length > 6) {
                        value = value.substring(0, 6)
                      }
                      e.target.value = value;
                    }}
                  />
                  <Form.Text className="text-muted">
                    {errors.password?.message}
                  </Form.Text>
                </Form.Group>
                <div className="d-grid gap-2">
                  <Button
                   className="button_login"
                   type="submit"
                   size="lg"
                   disabled={!isValid}
                   onLoad={() => isSubmitting}
                  >
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
