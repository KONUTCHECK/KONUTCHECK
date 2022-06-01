import React from "react";
import { Accordion, Button, Card, ListGroup, ListGroupItem } from "react-bootstrap";
import { Link, Navigate } from "react-router-dom";
import UserService from "../../api/UserService";


class UserInfoPage extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            user: {}
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

    handlerCancelResponse(response) {
        this.componentDidMount()
    }

    handleCancelError(error) {
        console.log("Kullanıcı silinirken hata oluştu");
    }

    render() {

        return (
            <div className="row p-1">
                <Card className="my-card">
                    <Card.Body>
                        <Card.Title>{this.state.user.name} {this.state.user.surname}</Card.Title>
                        <ListGroup>
                            <ListGroup.Item>{this.state.user.userType}</ListGroup.Item>
                            <ListGroup.Item>{this.state.user.age}</ListGroup.Item>
                            <ListGroup.Item>{this.state.user.gender}</ListGroup.Item>
                            <ListGroup.Item>{this.state.user.educationalStatus}</ListGroup.Item>
                            <ListGroup.Item>{this.state.user.job}</ListGroup.Item>
                            <ListGroup.Item>{this.state.user.maritialStatus}</ListGroup.Item>
                            <ListGroup.Item>{this.state.user.email}</ListGroup.Item>
                            <ListGroup.Item>{this.state.user.userPhoneNumber1}</ListGroup.Item>
                            <ListGroup.Item>{this.state.user.userPhoneNumber2}</ListGroup.Item>
                            <ListGroup.Item>{this.state.user.statusType}</ListGroup.Item>
                        </ListGroup>
                    </Card.Body>

                    <Card.Body>
                        <Button style={{ marginLeft: "10px" }}
                            className="btn btn-info" onClick={() => this.handleCancelUser()}>Hesabı Pasifleştir</Button>
                    </Card.Body>
                </Card>



            </div>
        );
    }
}
export default UserInfoPage;
