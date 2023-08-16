import { useEffect, useState } from "react";
import { Table, Button, Card, Container } from "react-bootstrap";
import { Account } from "../../../types/Account";
import { Link, useLocation } from "react-router-dom";
import { AccountValidation } from "../../../utils/AccountValidation";

export function ListApresentAccounts() {
  const location = useLocation();
  const [accounts, setAccounts] = useState<Array<Account>>([]);
  const [accountValidation] = useState(new AccountValidation());

  useEffect(() => {
    accountValidation.getAllByCustomerId(location.state.id).then((data) => {
      setAccounts(data);
    });
  }, []);

  return (
    <>
      <div className="ajust">
        <Container>
          <Card>
            <Card.Body>
              <Table striped bordered hover>
                <thead>
                  <tr>
                    <th className="text-center">Agency</th>
                    <th className="text-center">Account</th>
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
                          <Link
                            to={"/detail-account"}
                            state={{ id: account.id }}
                          >
                            <Button>Choose</Button>
                          </Link>
                        </td>
                      </tr>
                    );
                  })}
                </tbody>
              </Table>
            </Card.Body>
          </Card>
        </Container>
      </div>
    </>
  );
}
