import { useEffect, useState } from "react";
import Container from "react-bootstrap/esm/Container";
import Row from "react-bootstrap/esm/Row";
import Table from "react-bootstrap/Table";
import { Account } from "../../../models/Account";
import { useLocation, useNavigate } from "react-router-dom";
import Button from "react-bootstrap/Button";
import { AccountService } from "../../../services/AccountService";

export function ListApresentAccounts() {
  const location = useLocation();
  const navigate = useNavigate();
  const [accounts, setAccounts] = useState<Array<Account>>([]);

  useEffect(() => {
    const accountService = new AccountService();
    accountService.listAllById(location.state.id).then((data) => {
      if (typeof data === "object") {
        setAccounts(data);
      }
    });
  }, [setAccounts]);

  function handleChoose(account: Account) {
    navigate("/detail-account", {
      state: {
        id: account.id,
      },
    });
  }

  return (
    <>
      <div className="ajust">
        <Container className="container_list">
          <Row className="container_list_body">
            <Table striped bordered hover>
              <thead>
                <tr>
                  <th>Agency</th>
                  <th>Account</th>
                </tr>
              </thead>
              <tbody>
                {accounts.map((account) => {
                  return (
                    <tr key={account.id}>
                      <td align="center">
                        <span>{account.agency?.agency}</span>
                      </td>
                      <td align="center">
                        <span>{account.account}</span>
                      </td>
                      <td align="center">
                        <Button onClick={() => handleChoose(account)}>
                          Choose
                        </Button>
                      </td>
                    </tr>
                  );
                })}
              </tbody>
            </Table>
          </Row>
        </Container>
      </div>
    </>
  );
}
