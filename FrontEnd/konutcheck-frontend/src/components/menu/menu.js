import React from "react";
import { Container, Nav, Navbar, NavDropdown } from "react-bootstrap";
import logo from "./img/logoo.png";

class Menu extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            testState: "initialState"
        }

        this.handleLogout = this.handleLogout.bind(this);
    }

    handleLogout(){
        this.props.logout();
    }

    render() {
        return (
            <div className="col-md-12 offset-md-12 ">
                <Navbar bg="#fff" expand="lg">
                    <Container>
                        <Navbar.Brand href="/"><img src={logo} className="App-logo" /></Navbar.Brand>
                        <Navbar.Toggle aria-controls="basic-navbar-nav" />
                        <Navbar.Collapse id="basic-navbar-nav">
                            <Nav className="me-auto">
                                <Nav.Link href="/">Ana Sayfa</Nav.Link>
                                <Nav.Link href="/">Hakkımızda</Nav.Link>
                                <Nav.Link href="/homes">Evler</Nav.Link>
                                <Nav.Link href="/">Bize Ulaşın</Nav.Link>

                                <NavDropdown title="Hesabım" id="basic-nav-dropdown">

                                    <NavDropdown.Item href="/add-homes">Ev Ekle</NavDropdown.Item>
                                    <NavDropdown.Divider />
                                    {!this.props.isLoggedOn && < NavDropdown.Item href="/register">Kayıt Ol</NavDropdown.Item>}
                                    
                                    
                                    <NavDropdown.Divider />
                                    {!this.props.isLoggedOn && < NavDropdown.Item href="/login">Giriş</NavDropdown.Item>}
                                    {this.props.isLoggedOn && <NavDropdown.Item href="/" onClick={this.handleLogout}>Çıkış</NavDropdown.Item>}

                                
                                </NavDropdown>
                            </Nav>
                        </Navbar.Collapse>
                    </Container>
                </Navbar>
            </div> 
        );
    }
}

export default Menu;