import { useEffect, useState } from "react";
import Container from "react-bootstrap/esm/Container";
import Row from "react-bootstrap/esm/Row";
import ListGroup from "react-bootstrap/ListGroup";
import { Account } from "../../models/Account";
import { requestListAllById } from "../../utils/requestListId";

export function ListApresentAccounts() {
  const [accounts, setAccounts] = useState<Array<Account>>([]);

  useEffect(() => {
    requestListAllById("87110d15-6340-4db1-8a14-63ea369a7df9")
    .then((response) => {
      setAccounts(response);
    });
  }, [setAccounts]);

  return (
    <>
      <Container className="container_list">
        <Row className="container_list_body">
          <ListGroup variant="flush">
            <ListGroup.Item>Cras justo odio</ListGroup.Item>
          </ListGroup>
        </Row>
      </Container>
    </>
  );
}
