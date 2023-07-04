import { useEffect, useState } from "react";
import Container from "react-bootstrap/esm/Container";
import Row from "react-bootstrap/esm/Row";
import ListGroup from "react-bootstrap/ListGroup";
import { Account } from "../../models/Account";

export function ListApresentAccounts() {
  const [accounts, setAccounts] = useState<Array<Account>>([]);

  useEffect(() => {
    console.log("");
  }, [accounts]);

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
