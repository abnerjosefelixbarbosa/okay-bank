import Card from "react-bootstrap/Card";
import Container from "react-bootstrap/esm/Container";
import Row from "react-bootstrap/esm/Row";
import { Account } from "../../../models/entities/Account";
import CardHeader from "react-bootstrap/esm/CardHeader";

export function CardDetailAccounts({ account, agency, balance }: Account) {
  return (
    <>
      <Container className="container_detail_accounts">
        <Row>
          <Card className="card">
            <CardHeader className="center card_header">Account detail</CardHeader>
            <Card.Body>
                <label>Agency:</label> {agency?.agency}
                <br />
                <label>Account:</label> {account}
                <br />
                <label>Balance:</label> {balance}
            </Card.Body>
          </Card>
        </Row>
      </Container>
    </>
  );
}
