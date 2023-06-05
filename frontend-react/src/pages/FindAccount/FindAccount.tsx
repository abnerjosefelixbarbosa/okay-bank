import { Alert, Button, Container, TextField } from "@mui/material";
import { useState } from "react";
import { useIMask } from "react-imask";
import { Account } from "./../../models/Account";
import "./FindAccount.css";
import { useLocation, useNavigate } from "react-router-dom";
import { AccountService } from "../../services/AccountService/AccountService";

const AgencyMask = () => {
  const [optsAgency, setOptsAgency] = useState({
    mask: String("0000-0"),
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
  } = useIMask(optsAgency);

  return ref;
};

const AccountMask = () => {
  const [optsAccount, setOptsAccount] = useState({
    mask: String("00000-0"),
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
  } = useIMask(optsAccount);

  return ref;
};

export const FindAccount = () => {
  const agencyRef = AgencyMask();
  const accountRef = AccountMask();
  const [mesage, setMesage] = useState<string>("");
  const [showElement, setShowElement] = useState<boolean>(false);
  const location = useLocation();
  const [account, setAccount] = useState<Account>({ ...location.state });
  const navigate = useNavigate();

  //1568-1
  //13681-1
  //
  //2210-1
  //21224-1
  const handFindAccount = () => {
    const data: Account = {
      agency: agencyRef.current?.value,
      account: accountRef.current?.value,
    };

    AccountService()
      .findByAgencyAndAccount(data)
      .then((response) => {
        if (response.id === account.id) {
          showMesageError("conta logada");
        } else {
          navigate("/transfer", {
            state: {
              account1: account,
              account2: response,
            },
            replace: true,
          });
        }
      })
      .catch((e) => {
        showMesageError(e.message);
      });
  };

  const handBack = () => {
    navigate("/selection", { state: account, replace: true });
  };

  const showMesageError = (mesage: string) => {
    setMesage(mesage);
    setShowElement(true);
  };

  return (
    <>
      <div className="Transfer">
        <header>
          <div className="bar-header"></div>
        </header>
        <section>
          <Container className="container-find-account" maxWidth="xs">
            <form
              onSubmit={(e) => {
                e.preventDefault();
                handFindAccount();
              }}
            >
              <div className="container-header-form-find-account">
                {showElement ? (
                  <div id="alert-error">
                    <Alert variant="filled" severity="error">
                      <span>{mesage}</span>
                    </Alert>
                  </div>
                ) : null}
              </div>
              <br />
              <div className="container-body-form-find-account">
                <div>
                  <TextField
                    fullWidth
                    label="agência:"
                    id="agência"
                    size="small"
                    variant="filled"
                    type={"text"}
                    inputRef={agencyRef}
                  />
                </div>
                <div>
                  <TextField
                    fullWidth
                    label="conta:"
                    id="conta"
                    size="small"
                    variant="filled"
                    type={"text"}
                    inputRef={accountRef}
                  />
                </div>
              </div>
              <br />
              <div className="container-footer-form-find-account">
                <div className="center">
                  <Button
                    type="submit"
                    variant="contained"
                    className="button-find"
                  >
                    Encontrar
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
