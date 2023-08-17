import { Container, Nav, Navbar, NavDropdown } from "react-bootstrap";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { Account } from "../../../types/Account";

interface Props {
  account: Account;
}

export function NavbarDetailAccount({ account }: Props) {
  const [name, setName] = useState<string>("");

  useEffect(() => {
    if (account) {
      const list: Array<string> = account.customer.name.split(" ");
      setName(list[0]);
    }
  });

  return (
    <Navbar expand="lg" className="bg-body-tertiary navbar">
      <Container fluid>
        <Navbar.Brand>{`Hello ${name}`}</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            <NavDropdown  title="Operations" id="basic-nav-dropdown">
              <NavDropdown.Item
                as={Link}
                to="/find-account-and-agency"
                state={{
                  id: account?.id,
                  agency: account?.agency,
                  account: account,
                  balance: account?.balance,
                  password: account?.password,
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
