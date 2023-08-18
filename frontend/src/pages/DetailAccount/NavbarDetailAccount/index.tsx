import { Container, Nav, Navbar, NavDropdown } from "react-bootstrap";
import { Link } from "react-router-dom";
import { Account } from "../../../types/Account";
import { useCustomerName } from "../../../hooks/useCustomerName";
import { Customer } from "../../../types/Customer";

interface Props {
  account?: Account;
  customer?: Customer;
}

export function NavbarDetailAccount(props: Props) {
  const { name } = useCustomerName(props.customer!)

  return (
    <Navbar expand="lg" className="bg-body-tertiary navbar">
      <Container>
        <Navbar.Brand>{`Hello ${name}`}</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            <NavDropdown  title="Operations" id="basic-nav-dropdown">
              <NavDropdown.Item
                as={Link}
                to="/find-account-and-agency"
                state={{
                  id: props.account?.id,
                  balance: props.account?.balance,
                  password: props.account?.password,
                }}
              >
                Transfer balance
              </NavDropdown.Item>
            </NavDropdown>
          </Nav>
          <Nav>
            <Nav.Link as={Link} to="/" replace={true}>
              Logout
            </Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}
