import { useLocation, useNavigate } from "react-router-dom";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Alert from "react-bootstrap/Alert";
import Col from "react-bootstrap/Col";
import { findByAgencyAndAccount as servicesFindByAgencyAndAccount } from "../../../services/AccountService";
import { useForm } from "react-hook-form";
import { z } from "zod";
import { zodResolver } from "@hookform/resolvers/zod";

const schema = z.object({
  agency: z.string().regex(/^\d{10}/, "Agency invalid"),
  account: z.string().regex(/^\d{10}/, "Account invalid"),
});

type FormProps = z.infer<typeof schema>;

export function FormFindAccountAndAgency() {
  const location = useLocation();
  const navigate = useNavigate();
  const {
    register,
    handleSubmit,
    setError,
    formState: { errors, isSubmitting },
  } = useForm<FormProps>({
    mode: "all",
    reValidateMode: "onSubmit",
    resolver: zodResolver(schema),
  });

  function handleFind(data: FormProps) {
    servicesFindByAgencyAndAccount({ ...data, id: location.state.id })
      .then((data) => {
        navigate("/confirm-balance", {
          state: {
            id1: location.state.id,
            id2: data.id,
            password: location.state.password,
            balance: location.state.balance,
          },
        });
      })
      .catch((e) => {
        console.log(e.message);
        setError("root.random", { type: "random", message: e.message });
      });
  }

  return (
    <div className="ajust">
      <Container className="container_find_form">
        <Row>
          <Form onSubmit={handleSubmit(handleFind)}>
            <Row>
              <Col>
                {errors.root?.random.message ? (
                  <div>
                    <Alert variant="danger">
                      {errors.root?.random.message}
                    </Alert>
                  </div>
                ) : null}
              </Col>
            </Row>
            <Form.Group className="mb-3">
              <Form.Label>Agency</Form.Label>
              <Form.Control
                type="text"
                {...register("agency")}
                onChange={(e) => {
                  let value = e.target.value;
                  value = value.replace(/(\D)/g, "");
                  if (value.length > 10) {
                    value = value.substring(0, 10);
                  }
                  e.target.value = value;
                }}
              />
              <Form.Text className="text-muted text_color">
                {errors.agency?.message}
              </Form.Text>
            </Form.Group>
            <Form.Group className="mb-3">
              <Form.Label>Account</Form.Label>
              <Form.Control
                type="text"
                {...register("account")}
                onChange={(e) => {
                  let value = e.target.value;
                  value = value.replace(/(\D)/g, "");
                  if (value.length > 10) {
                    value = value.substring(0, 10);
                  }
                  e.target.value = value;
                }}
              />
              <Form.Text className="text-muted text_color">
                {errors.account?.message}
              </Form.Text>
            </Form.Group>
            <div className="d-grid gap-2">
              <Button
                className="button_find"
                type="submit"
                size="lg"
                onLoad={() => isSubmitting}
              >
                Find
              </Button>
            </div>
          </Form>
        </Row>
      </Container>
    </div>
  );
}
