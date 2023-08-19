import {
  Button,
  Form,
  Container,
  Row
} from "react-bootstrap";
import { useLocation, useNavigate } from "react-router-dom";
import { z } from "zod";
import { zodResolver } from "@hookform/resolvers/zod";
import { useForm } from "react-hook-form";
import { AccountValidation } from "../../../utils/AccountValidation";
import { useState } from "react";
import { ToastContainer, toast } from "react-toastify";

const schema = z.object({
  balance: z.coerce.number(),
});

type FormProps = z.infer<typeof schema>;

export function FormConfirmBalance() {
  const location = useLocation();
  const navigate = useNavigate();
  const [accountValidation] = useState(new AccountValidation);
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
    accountValidation.validBalance(data.balance, location.state.balance)
    .then(() => {
      navigate("/confirm-transfer", {
        state: {
          id1: location.state.id1,
          id2: location.state.id2,
          password: location.state.password,
          balance: data.balance,
        },
      });
    })
    .catch((e) => {
      if (e.message.includes("Balance")) {
        setError("balance", { type: "invalid", message: e.message });
      } else {
        toast.error(e.message, {
          autoClose: 3000,
          position: "top-center",
        })
      }
    })
  }

  return (
    <>
      <ToastContainer />
      <div className="ajust">
        <Container className="container_balance_form">
          <Row>
            <Form onSubmit={handleSubmit(handleConfirm)}>
              <Form.Group className="mb-3">
                <Form.Label>Balance</Form.Label>
                <Form.Control
                  type="text"
                  {...register("balance")}
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
