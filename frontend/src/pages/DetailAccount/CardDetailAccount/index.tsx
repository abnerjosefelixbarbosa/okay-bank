import { Card, Container, Row } from "react-bootstrap";
import { useProps } from "../../../hooks/useProps";

export function CardDetailAccounts() {
  const { account } = useProps();

  return (
    <>
      <Container className="container_detail_accounts">
        <Row>
          <Card>
            <Card.Body>
              <Card.Title>Detail Account</Card.Title>
              <br />
              <label>Customer Name: { account.customer?.name }</label>
              <br />
              <label>Agency: { account.agency?.agency }</label>
              <br />
              <label>Account: { account.account }</label>
              <br />
              <label>Balance: { account?.balance?.toFixed(2) }</label>
            </Card.Body>
          </Card>
        </Row>
      </Container>
    </>
  );
}
