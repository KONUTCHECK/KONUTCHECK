import React from "react";
import { Container, Nav, Navbar, NavDropdown, } from "react-bootstrap";
import logo from "./img/logooo.png";


class Footer extends React.Component {

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
            <div className="footer" >
                <Navbar expand="lg">
                    <Container>
                        <Navbar.Toggle aria-controls="basic-navbar-nav" />
                        <Navbar.Collapse id="basic-navbar-nav">
                            <Nav className="me-auto">

                                <div className="footer-item">
                                <Navbar.Brand href="/"><img src={logo} className="App-logo" /></Navbar.Brand>
                                    <p className="about-us">Ankara Yıldırım Beyazıt Üniversitesi Yönetim Bilişim Sistemleri bölümünde eğitim gören son sınıf öğrencileriyiz. Yaşanılan ortak bir sorundan yola çıkarak ihtiyaç doğrultusunda insanların
                                        konut kiralama konusunda yaşadıkları güven problemine çözüm bulma amacıyla birleşmiş bulunmaktayız.
                                    </p>
                                </div>

                                <div className="footer-item">
                                    <h4>HİZMETLER</h4>
                                    <ul>
                                        <a href="#" className="footer-links">
                                            <li>Evinizi Kiraya Verin</li>
                                        </a>
                                        <a href="#" className="footer-links">
                                            <li>Kiralık Ev Bulun</li>
                                        </a>
                                    </ul>
                                </div>
                                <div className="footer-item">
                                    <h4>BİZE ULAŞIN</h4>

                                    <a href="mailto:" className="footer-links">
                                    info@konutcheck.com </a>
                                    <ul className="footer-social-links">

                                        <li>
                                            <button className="btn-social">
                                                <a href="https://www.bt21.com/character" target="_blank">
                                                    <i className="fab fa-google"></i>
                                                </a>
                                            </button>
                                        </li>
                                        <li>
                                            <button className="btn-social">
                                                <a href="https://twitter.com/bt21_" target="_blank">
                                                    <i className="fab fa-twitter"></i>
                                                </a>
                                            </button>
                                        </li>
                                        <li>
                                            <button className="btn-social">
                                                <a href="https://www.youtube.com/channel/UCINr5W7cwW06ADtsszAToAw" target="_blank">
                                                    <i className="fab fa-youtube"></i>
                                                </a>
                                            </button>
                                        </li>
                                    </ul>


                                </div>

                            </Nav>


                        </Navbar.Collapse>

                    </Container>
                </Navbar>

                <div className="copyright">

                    <div className="container">
                        <small> Tüm Hakları Saklıdır. © KONUTCHECK 2022</small>
                    </div>

                </div>
            </div>
        );
    }
}

export default Footer;