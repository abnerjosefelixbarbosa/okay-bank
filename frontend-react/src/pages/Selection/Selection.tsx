import { Link, useLocation } from "react-router-dom";
import { Account } from "./../../models/Account";
import { Customer } from "./../../models/Customer";
import "./Selection.css";
import { useState } from "react";
import { Card, CardContent, Container, Typography } from "@mui/material";

export const Selection = () => {
  const location = useLocation();
  const [account, setAccount] = useState<Account>({ ...location.state });
  const [customer, setCustomer] = useState<Customer>({ ...account.customer });

  return (
    <>
      <div className="Selection">
        <header>
          <nav>
            <ul>
              <li className="band">
                <a>{customer.name?.substring(0, 2).toUpperCase()}</a>
              </li>
              <li className="dropdown">
                <a className="dropbtn" href="">
                  Operações
                </a>
                <div className="dropdown-content">
                  <Link to="/find-account" state={account} replace={true}>
                    Tranferência
                  </Link>
                </div>
              </li>
              <li className="logout">
                <Link to="/" replace={true}>
                  Sair
                </Link>
              </li>
            </ul>
          </nav>
        </header>

        <section>
          <Container className="container-balance" maxWidth="xs">
            <Card sx={{ maxWidth: 345 }}>
              <CardContent>
                <Typography gutterBottom variant="h5" component="div">
                  Saldo
                </Typography>
                <Typography variant="body2" color="text.secondary">
                  {account.balance}
                </Typography>
              </CardContent>
            </Card>
          </Container>

          <Container className="container-card" maxWidth="xs">
            <Card sx={{ maxWidth: 345 }}>
              <CardContent>
                <Typography gutterBottom variant="h5" component="div">
                  Cartão
                </Typography>
                <Typography variant="body2" color="text.secondary">
                  Adiquira seu cartão.
                </Typography>
              </CardContent>
            </Card>
          </Container>

          <Container className="container-account" maxWidth="xs">
            <Card sx={{ maxWidth: 345 }}>
              <CardContent>
                <Typography gutterBottom variant="h5" component="div">
                  Conta Prêmio
                </Typography>
                <Typography variant="body2" color="text.secondary">
                  Crie sua conta prêmio e ganhe vantagens.
                </Typography>
              </CardContent>
            </Card>
          </Container>
        </section>
        
        <footer>
          <div className="bar-footer"></div>
        </footer>
      </div>
    </>
  );
};
