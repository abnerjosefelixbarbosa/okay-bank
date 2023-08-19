import {
  Button,
  Container,
  Row,
  Form
} from "react-bootstrap";
import { useLocation } from "react-router-dom";
import { z } from "zod";
import { useForm } from "react-hook-form";
import { zodResolver } from "@hookform/resolvers/zod";

const schema = z.object({
  password: z
    .string()
    .nonempty("Password is empty")
    .min(4, { message: "Password greater than 4 characters" }),
});

type FormProps = z.infer<typeof schema>;

export function FormConfirmTransfer() {
  const location = useLocation();
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

  function handleConfirm(data: FormProps) {
    //
  }

  //console.log(location.state)

  return (
    <>
      <div className="ajust">
        <Container className="container_transfer_form">
          <Row>
            <Form onSubmit={handleSubmit(handleConfirm)}>
              <Form.Group className="mb-3">
                <Form.Label>Password</Form.Label>
                <Form.Control
                  type="password"
                  {...register("password")}
                  onChange={(e) => {
                    let value = e.target.value;
                    value = value.replace(/\D/g, "");
                    if (value.length > 4) {
                      value = value.substring(0, 4);
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
