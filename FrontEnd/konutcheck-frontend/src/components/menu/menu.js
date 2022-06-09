import React from "react";
import { Container, Nav, Navbar, NavDropdown } from "react-bootstrap";
import logo from "../homePage/img/logooo.png";


class Menu extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            testState: "initialState"
        }

        this.handleLogout = this.handleLogout.bind(this);
    }

    handleLogout() {
        this.props.logout();
    }

    render() {
        return (
            <div className="col-md-12 offset-md-12">
                <Navbar bg="#5b2f83" expand="lg">
                    <Container>
                        <Navbar.Brand href="/"><img src={logo} className="App-logo" /></Navbar.Brand>
                        <Navbar.Toggle aria-controls="basic-navbar-nav" />
                        <Navbar.Collapse id="basic-navbar-nav">
                            <Nav className="me-auto">
                                <Nav.Link href="/">ANA SAYFA</Nav.Link>
                                <Nav.Link href="/">HAKKIMIZDA</Nav.Link>
                                {this.props.isLoggedOn && <Nav.Link href="/homes" >EVLER</Nav.Link>}
                                {this.props.isLoggedOn && <Nav.Link href="/users">KULLANICILAR</Nav.Link>}
                                <Nav.Link href="/">BİZE ULAŞIN</Nav.Link>


                                <NavDropdown title="HESABIM" id="basic-nav-dropdown">



                                    {!this.props.isLoggedOn && < NavDropdown.Item href="/register">Kayıt Ol</NavDropdown.Item>}
                                    {!this.props.isLoggedOn && < NavDropdown.Item href="/login">Giriş</NavDropdown.Item>}
                                    {this.props.isLoggedOn && <NavDropdown.Item href="/user-info">Profilim</NavDropdown.Item>}
                                    {this.props.isLoggedOn && this.props.userType === 'Evsahibi' && <NavDropdown.Item href="/add-homes">Ev Ekle</NavDropdown.Item>}
                                    {this.props.isLoggedOn && this.props.userType === 'Evsahibi' && <NavDropdown.Item href="/list-passive-homes">Ev Onayla</NavDropdown.Item>}
                                    {this.props.isLoggedOn && this.props.userType === 'Kiracı' && <NavDropdown.Item href="/tenant-homes">Kiracı Olduğum Evler</NavDropdown.Item>}
                                    {this.props.isLoggedOn && this.props.userType === 'Evsahibi' && <NavDropdown.Item href="/landlord-homes">Sahip Olduğum Evler</NavDropdown.Item>}
                                    {this.props.isLoggedOn && this.props.userType === 'Evsahibi' && <NavDropdown.Item href="/landlord-tenants">Kiracılarım</NavDropdown.Item>}
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