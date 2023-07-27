import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import { useLocation, useNavigate } from "react-router-dom";
import Alert from "react-bootstrap/Alert";
import Col from "react-bootstrap/Col";
import { z } from "zod";
import { zodResolver } from "@hookform/resolvers/zod";
import { useForm } from "react-hook-form";

const schema = z.object({
  balance: z.number(),
});

type FormProps = z.infer<typeof schema>;

export function FormConfirmBalance() {
  const location = useLocation();
  const navigate = useNavigate();
  const {
    register,
    handleSubmit,
    setError,
    setValue,
    formState: { errors, isSubmitting },
  } = useForm<FormProps>({
    mode: "all",
    reValidateMode: "onSubmit",
    resolver: zodResolver(schema),
  });

  function handleConfirm(data: FormProps) {
    console.log(data);
    /*
        navigate("/confirm-transfer", {
          state: {
            id1: location.state.id1,
            id2: location.state.id2,
            password: location.state.password,
            balance: account.balance,
          },
        });
        */
  }

  return (
    <>
      <div className="ajust">
        <Container className="container_balance_form">
          <Row>
            <Form onSubmit={handleSubmit(handleConfirm)}>
              <Row>
                <Col>
                  {errors.root?.random.message ? (
                    <Alert variant="danger">
                      {errors.root?.random.message}
                    </Alert>
                  ) : null}
                </Col>
              </Row>
              <Form.Group className="mb-3">
                <Form.Label>Balance</Form.Label>
                <Form.Control
                  type="text"
                  {...register("balance", { valueAsNumber: true })}
                  onChange={(e) => {
                    let value = e.target.value;
                    value = value.replace(/\D/g, "");
                    value = value.replace(/(\d+)(\d{2})$/, "$1.$2");
                    e.target.value = value;
                  }}
                />
                <Form.Text className="text-muted text_color">
                  {errors.balance?.message}
                </Form.Text>
              </Form.Group>
              <div className="d-grid gap-2">
                <Button
                  className="btn_confirm"
                  type="submit"
                  size="lg"
                  onLoad={() => isSubmitting}
                >
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
