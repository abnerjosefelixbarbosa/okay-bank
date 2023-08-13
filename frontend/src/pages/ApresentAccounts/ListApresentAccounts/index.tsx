import { useEffect, useState } from "react";
import Container from "react-bootstrap/esm/Container";
import Row from "react-bootstrap/esm/Row";
import Table from "react-bootstrap/Table";
import { Account } from "../../../types/Account";
import { Link, useLocation } from "react-router-dom";
import Button from "react-bootstrap/Button";
import { getAllByCustomerId as serviceGetAllByCustomerId } from "../../../services/AccountService";

export function ListApresentAccounts() {
  const location = useLocation();
  const [accounts, setAccounts] = useState<Array<Account>>([]);

  useEffect(() => {
    serviceGetAllByCustomerId(location.state.id)
    .then((data) => setAccounts(data));
  }, []);

  return (
    <>
      <div className="ajust">
        <Container className="container_list">
          <Row className="container_list_body">
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
                          state={ {id: account.id} }>
                          <Button>
                            Choose
                          </Button>
                        </Link>                        
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
