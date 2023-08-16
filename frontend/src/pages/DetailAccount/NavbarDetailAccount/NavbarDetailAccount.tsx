import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import NavDropdown from "react-bootstrap/NavDropdown";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { Agency } from "../../../types/Agency";
import { Account } from "../../../types/Account";

interface Props {
  account: Account,
  agency: Agency,
}

export function NavbarDetailAccount({ account, agency }: Props) {
  const [name, setName] = useState<string>("");

  useEffect(() => {
    const list: Array<string> = account.customer.name.split(" ");
    setName(list[0]);
  }, []);

  return (
    <Navbar expand="lg" className="bg-body-tertiary navbar">
      <Container fluid>
        <Navbar.Brand>{`Hello ${name}`}</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            <Nav.Link>
              <Link className="link_navbar" to="/" replace={true}>
                Logout
              </Link>
            </Nav.Link>
            <NavDropdown active title="Operations" id="basic-nav-dropdown">
              <NavDropdown.Item>
                <Link
                  className="link_navbar"
                  to="/find-account-and-agency"
                  state={{
                    "id": account.id,
                    "agency": agency,
                    "account": account,  
                    "balance": account.balance,
                    "password": account.password                  
                  }}
                >
                  Transfer balance
                </Link>
              </NavDropdown.Item>
            </NavDropdown>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}
