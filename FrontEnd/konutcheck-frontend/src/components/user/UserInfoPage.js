import React from "react";
import { Accordion, Button, Card, ListGroup, ListGroupItem } from "react-bootstrap";
import { Link, Navigate } from "react-router-dom";
import UserService from "../../api/UserService";



class UserInfoPage extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            user: {},
            isuserpassive: false
        }

    }

    componentDidMount() {
        this.getUserList();
    }

    getUserList() {
        UserService.getUserInfo().then(response => this.handlerResponse(response)).catch(error => this.handleError(error));
    }

    handlerResponse(response) {
        this.setState({ user: response.data })
    }

    handleError(error) {
        console.log("Kullanıcılar çekilirken hata oluştu");
    }

    handleCancelUser() {
        UserService.cancelUser().then(response => this.handlerCancelResponse(response)).catch(error => this.handleCancelError(error));
    }
    handleUserBack() {
        UserService.getUserBack().then(response => this.handlerCancelResponse(response)).catch(error => this.handleCancelError(error));
    }

    handlerCancelResponse(response) {
        console.log(response)
        this.componentDidMount()
    }

    handleCancelError(error) {
        console.log("Kullanıcı silinirken hata oluştu");
    }

    setData(user) {
        let { id, name, surname, age, userType, gender, educationalStatus, job, maritialStatus, email, userPhoneNumber1, userPhoneNumber2,
            password } = user;
        localStorage.setItem('id', id);
        localStorage.setItem('İsim', name);
        localStorage.setItem('Soyisim', surname);
        localStorage.setItem('Yaş', age);
        localStorage.setItem('Kullanıcı Tipi', userType);
        localStorage.setItem('Cinsiyet', gender);
        localStorage.setItem('Eğitim Durumu', educationalStatus);
        localStorage.setItem('Meslek', job);
        localStorage.setItem('Evlilik Durumu', maritialStatus);
        localStorage.setItem('Mail Adresi', email);
        localStorage.setItem('Telefon Numarası 1 ', userPhoneNumber1);
        localStorage.setItem('Telefon Numarası 2 ', userPhoneNumber2);
        localStorage.setItem('Şifre', password);
       
        console.log(user)
    }


    render() {


        return (
            <div className="row p-1">

                <Card className="my-card">
                    <Card.Body>
                        <Card.Title><b>Adı-Soyadı: </b>{this.state.user.name} {this.state.user.surname}</Card.Title>
                        <ListGroup>
                            <ListGroup.Item><b>Kullanıcı Tipi: </b>{this.state.user.userType}</ListGroup.Item>
                            <ListGroup.Item><b>Yaşı: </b>{this.state.user.age}</ListGroup.Item>
                            <ListGroup.Item><b>Cinsiyet: </b>{this.state.user.gender}</ListGroup.Item>
                            <ListGroup.Item><b>Eğitim: </b>{this.state.user.educationalStatus}</ListGroup.Item>
                            <ListGroup.Item><b>Meslek: </b>{this.state.user.job}</ListGroup.Item>
                            <ListGroup.Item><b>Medeni Hal: </b>{this.state.user.maritialStatus}</ListGroup.Item>
                            <ListGroup.Item><b>Email Adresi:</b>{this.state.user.email}</ListGroup.Item>
                            <ListGroup.Item><b>1. Telefon Numarası: </b>{this.state.user.userPhoneNumber1}</ListGroup.Item>
                            <ListGroup.Item><b>2. Telefon Numarası</b>{this.state.user.userPhoneNumber2}</ListGroup.Item>
                            <ListGroup.Item><b>Aktiflik/Pasiflik: </b>{this.state.user.statusType}</ListGroup.Item>
                        </ListGroup>
                    </Card.Body>

                    <Card.Body>
                        {this.state.user.statusType === "Aktif" && <Button style={{ marginLeft: "10px" }}
                            className="btn btn-info" onClick={() => { this.handleCancelUser() }}>Hesabı Pasifleştir</Button>}
                        {this.state.user.statusType === "Pasif" &&
                            <Button style={{ marginLeft: "10px", backgroundColor: "#2eb12e" }}
                                className="btn btn-info" onClick={() => { this.handleUserBack() }}>Hesabı Aktifleştir</Button>}

                        <Link to="/update-user-infos">
                            <Button style={{ marginLeft: "59rem" }}
                                className="btn btn-update" onClick={() => this.setData(this.state.user)}>Bilgilerimi Güncelle</Button>
                        </Link>
                    </Card.Body>
                </Card>



            </div>
        );
    }
}
export default UserInfoPage;
