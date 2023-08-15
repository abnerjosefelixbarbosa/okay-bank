import Card from "react-bootstrap/Card";
import Container from "react-bootstrap/esm/Container";
import Row from "react-bootstrap/esm/Row";
import CardHeader from "react-bootstrap/esm/CardHeader";

interface Props {
  account: string,
  agency: string,
  balance: number
} 

export function CardDetailAccounts({ account, agency, balance }: Props) {
  return (
    <>
      <Container className="container_detail_accounts">
        <Row>
          <Card>
            <CardHeader className="center card_header">Account detail</CardHeader>
            <Card.Body>
                <label>Agency:</label> {agency}
                <br />
                <label>Account:</label> {account}
                <br />
                <label>Balance:</label> {balance.toFixed(2)}
            </Card.Body>
          </Card>
        </Row>
      </Container>
    </>
  );
}
