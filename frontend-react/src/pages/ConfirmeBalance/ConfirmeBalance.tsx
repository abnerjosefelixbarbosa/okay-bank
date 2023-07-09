import "./style.css";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";

export function ConfirmeBalance() {
  return (
    <>
      <FormConfirmeBalance />
    </>
  );
}

function FormConfirmeBalance() {


  function onConfirm() {
    alert("test");
  }

  return (
    <>
      <div className="ajust">
        <Container className="container_balance_form">
          <Row>
            <Form onSubmit={(e) => {
              e.preventDefault();
              onConfirm();
            }}>
              <Form.Group className="mb-3">
                <Form.Label>Balance</Form.Label>
                <Form.Control type="number" />
              </Form.Group>
              <div className="d-grid gap-2">
                <Button variant="primary" type="submit" size="lg">
                  Confirm
                </Button>
              </div>
            </Form>
          </Row>
        </Container>
      </div>
    </>
  );
}
