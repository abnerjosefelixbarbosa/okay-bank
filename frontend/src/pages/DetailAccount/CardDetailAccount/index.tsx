import {Card, Container, Row} from "react-bootstrap";
import { Account } from "../../../types/Account";

interface Props {
  account: Account
}

export function CardDetailAccounts({ account } : Props) {
  //const [account, setAccount] = useState<Account>(props.account);
  //console.log(account)

  return (
    <>
      <Container className="container_detail_accounts">
        <Row>
          <Card>
            <Card.Header className="center card_header">
              Account detail
            </Card.Header>
            <Card.Body>
                <label>Agency: { account?.agency.agency }</label>
                <br />
                <label>Account: { account?.account }</label>
                <br />
                <label>Balance: { account?.balance.toFixed(2) }</label>
            </Card.Body>
          </Card>
        </Row>
      </Container>
    </>
  );
}
