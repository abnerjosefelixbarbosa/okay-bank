import { Alert, Button, Container, TextField } from "@mui/material";
import "./ConfirmAccount.css";
import { useState } from "react";
import { useIMask } from "react-imask";
import { useLocation, useNavigate } from "react-router-dom";
import { Account } from "./../../models/Account";
import { AccountService } from "../../services/AccountService/AccountService";

const PasswordMask = () => {
  const [optsPassword, setOptsPassword] = useState({
    mask: String("0000"),
  });

  const {
    ref,
    maskRef,
    value,
    setValue,
    unmaskedValue,
    setUnmaskedValue,
    typedValue,
    setTypedValue,
  } = useIMask(optsPassword);

  return ref;
};

export const ConfirmAccount = () => {
  const [mesage, setMesage] = useState<string>("");
  const [showElement, setShowElement] = useState<boolean>(false);
  const location = useLocation();
  const navigate = useNavigate();
  const refPassword = PasswordMask();
  const [account1, setAccount1] = useState<Account>({
    ...location.state.account1,
  });
  const [account2, setAccount2] = useState<Account>({
    ...location.state.account2,
  });
  const [accountData, setAccountData] = useState<Account>({
    ...location.state.data,
  });

  //4812
  //
  //5832
  const handConfirm = () => {
    const data: Account = {
      password: refPassword.current?.value,
      balance: accountData.balance,
    };

    AccountService()
      .transferBalance(account1, account2, data)
      .then(() => {
        const balance1: any = account1.balance;
        const balance2: any = data.balance;
        account1.balance = balance1 - balance2;
        navigate("/find-account", { state: account1, replace: true });
      })
      .catch((e) => {
        showMesageError(e.message);
      });
  };

  const handBack = () =>
    navigate("/transfer", {
      state: {
        account1: account1,
        account2: account2,
        data: accountData,
      },
      replace: true,
    });

  const showMesageError = (mesage: string) => {
    setMesage(mesage);
    setShowElement(true);
  };

  return (
    <>
      <div className="confirm-account">
        <header>
          <div className="bar-header"></div>
        </header>

        <section>
          <Container className="container-confirm" maxWidth="xs">
            <form
              onSubmit={(e) => {
                e.preventDefault();
                handConfirm();
              }}
            >
              <div className="container-header-form-confirm">
                {showElement ? (
                  <div id="alert-error">
                    <Alert variant="filled" severity="error">
                      <span>{mesage}</span>
                    </Alert>
                  </div>
                ) : null}
              </div>
              <br />
              <div className="container-body-form-confirm">
                <div>
                  <TextField
                    fullWidth
                    label="senha:"
                    id="senha"
                    size="small"
                    variant="filled"
                    type={"password"}
                    inputRef={refPassword}
                  />
                </div>
              </div>
              <br />
              <div className="container-footer-form-confirm">
                <div className="center">
                  <Button
                    type="submit"
                    variant="contained"
                    className="button-confirm"
                  >
                    Confirmar
                  </Button>
                </div>
                <br />
                <div className="center">
                  <Button
                    type="button"
                    variant="contained"
                    className="button-back"
                    onClick={() => handBack()}
                  >
                    Voltar
                  </Button>
                </div>
              </div>
            </form>
          </Container>
        </section>

        <footer>
          <div className="bar-footer"></div>
        </footer>
      </div>
    </>
  );
};
