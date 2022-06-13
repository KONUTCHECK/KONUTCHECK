import React from "react";
import { Button } from "react-bootstrap";
import { Accordion, ListGroup } from "react-bootstrap";
import UserService from "../../api/UserService";
import Usertype from "../general/combobox/RegisterCombobox/Usertype";


class UserListPage extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            userList: [],
            userType: ""
        }
        this.handlerChange = this.handlerChange.bind(this);
    }

    componentDidMount() {
        this.getUserList();
    }

    getUserList() {
        UserService.findAllUsers().then(response => this.handlerResponse(response)).catch(error => this.handleError(error));
    }

    handlerResponse(response) {
        this.setState({ userList: response.data })
    }

    handleError(error) {
        console.log("Kullanıcılar çekilirken hata oluştu");
    }
    handleSearch() {
        UserService.getUserByType(this.state.userType).then(response => this.handlerResponse(response))
            .catch(error => this.handleError(error))
    }


    handlerChange(event) {
        this.setState({ [event.target.name]: event.target.value })
        console.log(this.state)
    }

    render() {

        return (

            <>
                <div className="row p-1">
                    <div className="col-sm-3">
                        Kullanıcı Tipi
                        <Usertype
                            type="combobox"
                            value={this.state.userType}
                            fieldName="userType"
                            onChange={this.handlerChange}
                        >
                        </Usertype>

                    </div>
                    <div className="col-sm-3">
                        <div className="d-grid gap-2">
                            <Button variant="secondary" onClick={() => this.handleSearch()} onChange={this.handlerChange}>Arama</Button>
                        </div>

                    </div>
                </div>
                {
                    this.state.userList.map((user, i) => (
                        <div className="row p-1" key={user.id}>
                            <Accordion className="user-table" defaultActiveKey="0">
                                <Accordion.Item eventKey="0">
                                    <Accordion.Header><b>Adı- Soyadı: </b> {user.name} {user.surname} {user.userType}</Accordion.Header>
                                    <Accordion.Body>
                                        <ListGroup>
                                            <ListGroup.Item className="one-user"> <b>Yaşı: </b> {user.age}</ListGroup.Item>
                                            <ListGroup.Item className="one-user"><b>Cinsiyet: </b>{user.gender}</ListGroup.Item>
                                            <ListGroup.Item className="one-user"><b>Eğitim: </b>{user.educationalStatus}</ListGroup.Item>
                                            <ListGroup.Item className="one-user"><b>Meslek: </b>{user.job}</ListGroup.Item>
                                            <ListGroup.Item className="one-user"><b>Medeni Hali: </b>{user.maritialStatus}</ListGroup.Item>
                                            <ListGroup.Item className="one-user"><b>Email Adresi: </b>{user.email}</ListGroup.Item>
                                            <ListGroup.Item className="one-user"><b>1. Telefon Numarası: </b>{user.userPhoneNumber1}</ListGroup.Item>
                                            <ListGroup.Item className="one-user"><b>2. Telefon Numarası: </b>{user.userPhoneNumber2}</ListGroup.Item>
                                        </ListGroup>
                                    </Accordion.Body>
                                </Accordion.Item>

                            </Accordion>
                        </div>


                    ))
                }
            </>
        );
    }
}
export default UserListPage;
