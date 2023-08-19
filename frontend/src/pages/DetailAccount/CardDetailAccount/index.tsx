import {Card, Container, Row} from "react-bootstrap";
import { Account } from "../../../types/Account";
import { Agency } from "../../../types/Agency";
import { Customer } from "../../../types/Customer";

interface Props {
  account?: Account;
  agency?: Agency;
  customer?: Customer;
}

export function CardDetailAccounts(props : Props) {
  return (
    <>
      <Container className="container_detail_accounts">
        <Row>
          <Card>
            <Card.Body>
                <Card.Title>Detail Account</Card.Title>
                <br />
                <label>Customer Name: { props.customer?.name }</label>
                <br />
                <label>Agency: { props.agency?.agency }</label>
                <br />
                <label>Account: { props.account?.account }</label>
                <br />
                <label>Balance: { props.account?.balance?.toFixed(2) }</label>
            </Card.Body>
          </Card>
        </Row>
      </Container>
    </>
  );
}
