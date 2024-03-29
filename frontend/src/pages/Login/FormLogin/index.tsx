import { Form, Container, Row, Button } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import { useForm } from "react-hook-form";
import { z } from "zod";
import { zodResolver } from "@hookform/resolvers/zod";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/ReactToastify.css";
import { Customer } from "../../../types/Customer";
import { useCallback, useState } from "react";
import { CustomerService } from "../../../services/CustomerService";

const schema = z.object({
  cpf: z.string().regex(/^\d{3}\.\d{3}\.\d{3}-\d{2}$/, "CPF invalid"),
  password: z.string().regex(/^\d{6}$/, "Password invalid"),
});

type FormLogin = z.infer<typeof schema>;

export function FormLogin() {
  const navigate = useNavigate();
  const [customerService] = useState(new CustomerService());
  const {
    register,
    handleSubmit,
    setError,
    formState: { errors, isSubmitting },
  } = useForm<FormLogin>({
    mode: "onSubmit",
    reValidateMode: "onSubmit",
    resolver: zodResolver(schema),
  });

  function handleLogin(data: FormLogin) {
    const newCustomer: Customer = {
      cpf: data.cpf,
      password: data.password,
    };

    try {
      customerService.validCpf(newCustomer);
      customerService
        .loginByCpfAndPassword(newCustomer)
        .then((data) => {
          navigate("/apresent-accounts", {
            replace: true,
            state: {
              id: data.id
            }
          });
        })
        .catch((error) => {
          const message: string = error.message;

          toast.error(message, {
            autoClose: 3000,
            position: "top-center",
          });
        });
    } catch (error: any) {
      const message: string = error.message;

      if (message.includes("CPF invalid"))
        setError("cpf", { message: message });
    }
  }

  return (
    <>
      <ToastContainer />
      <div className="ajust">
        <Container className="container_login_form">
          <Row>
            <Form className="login_form" onSubmit={handleSubmit(handleLogin)}>
              <Row className="title_login_form">
                <h1>Okay Bank</h1>
              </Row>
              <Row className="body_login_form">
                <Form.Group className="mb-3" controlId="cpf">
                  <Form.Label>CPF:</Form.Label>
                  <Form.Control
                    type="text"
                    {...register("cpf")}
                    onChange={(e) => {
                      let value = e.target.value;
                      value = value.replace(/(\D)/g, "");
                      if (value.length > 11) {
                        value = value.substring(0, 11);
                      }
                      value = value.replace(
                        /(\d{3})(\d{3})(\d{3})(\d{2})/g,
                        "$1.$2.$3-$4"
                      );
                      e.target.value = value;
                    }}
                  />
                  <Form.Text className="text-muted text_color">
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
                        value = value.substring(0, 6);
                      }
                      e.target.value = value;
                    }}
                  />
                  <Form.Text className="text-muted text_color">
                    {errors.password?.message}
                  </Form.Text>
                </Form.Group>
                <div className="d-grid gap-2">
                  <Button
                    className="button_login"
                    type="submit"
                    size="lg"
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
