import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import NavDropdown from "react-bootstrap/NavDropdown";
import { useEffect, useState } from "react";
import { Account } from "../../models/Account";
import { Link } from "react-router-dom";

export function NavbarDetailAccount({ customer, id }: Account) {
  const [name, setName] = useState<string>("");

  useEffect(() => {
    if (customer?.name !== undefined) {
      const list: Array<string> = customer.name.split(" ");
      setName(list[0]);
    }
  });

  return (
    <Navbar expand="lg" className="bg-body-tertiary">
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
                    "id": id
                  }}
                  replace={true}
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
