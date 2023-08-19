import { useLocation, useNavigate } from "react-router-dom";
import { Button, Form, Container, Row } from "react-bootstrap";
import { AccountValidation } from "../../../utils/AccountValidation";
import { useForm } from "react-hook-form";
import { z } from "zod";
import { zodResolver } from "@hookform/resolvers/zod";
import { useState } from "react";
import { Account } from "../../../types/Account";
import { ToastContainer, toast } from "react-toastify";
import { Agency } from "../../../types/Agency";

const schema = z.object({
  agency: z.string().regex(/^\d{10}/, "Agency invalid"),
  account: z.string().regex(/^\d{10}/, "Account invalid"),
});

type FormProps = z.infer<typeof schema>;

export function FormFindAccountAndAgency() {
  const location = useLocation();
  const navigate = useNavigate();
  const [accountValidation] = useState(new AccountValidation());
  const {
    register,
    handleSubmit,
    formState: { errors, isSubmitting },
  } = useForm<FormProps>({
    mode: "all",
    reValidateMode: "onSubmit",
    resolver: zodResolver(schema),
  });

  function handleFind(data: FormProps) {
    const newAgency: Agency  = {
      agency: data.agency,
    } 
    const newAccount: Account = { 
      id: location.state.id,
      account: data.account,
      agency: newAgency
    }

    accountValidation.findByAgencyAndAccount(newAccount)
    .then((data) => {
      navigate("/confirm-balance", {
        state: {
          id1: location.state.id,
          id2: data.id,
          balance: location.state.balance,
          password: location.state.password,
        }        
      })
    })
    .catch((e) => {
      toast.error(e.message, {
        autoClose: 3000,
        position: "top-center",
      });
    });
  }

  return (
    <>
    <ToastContainer />
    <div className="ajust">
      <Container className="container_find_form">
        <Row>
          <Form onSubmit={handleSubmit(handleFind)}>
            <Form.Group className="mb-3">
              <Form.Label>Agency</Form.Label>
              <Form.Control
                type="password"
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
                type="password"
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
    </>
  );
}
