import {Card, Container, Row} from "react-bootstrap";
import { Account } from "../../../types/Account";
import { Agency } from "../../../types/Agency";

interface Props {
  account?: Account;
  agency?: Agency;
}

export function CardDetailAccounts(props : Props) {
  return (
    <>
      <Container className="container_detail_accounts">
        <Row>
          <Card>
            <Card.Header className="center card_header">
              Account detail
            </Card.Header>
            <Card.Body>
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
