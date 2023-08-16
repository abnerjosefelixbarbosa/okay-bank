import {Card, Container, Row} from "react-bootstrap";
import { Account } from "../../../types/Account";
import { Agency } from "../../../types/Agency";

interface Props {
  account: Account,
  agency: Agency,
} 

export function CardDetailAccounts({ account, agency }: Props) {
  return (
    <>
      <Container className="container_detail_accounts">
        <Row>
          <Card>
            <Card.Header className="center card_header">
              Account detail
            </Card.Header>
            <Card.Body>
                <label>Agency:</label> {agency.agency}
                <br />
                <label>Account:</label> {account.account}
                <br />
                <label>Balance:</label> {account.balance.toFixed(2)}
            </Card.Body>
          </Card>
        </Row>
      </Container>
    </>
  );
}
