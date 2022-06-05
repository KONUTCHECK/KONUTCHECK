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

    render() {

        return (

            
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
                

                {this.state.userList.map((user, i) => (
                    <Accordion key={user.id}>
                        <Accordion.Item eventKey="0">
                            <Accordion.Header>{user.name} {user.surname}{user.userType}</Accordion.Header>
                            <Accordion.Body>
                                <ListGroup>
                                    <ListGroup.Item>{user.age}</ListGroup.Item>
                                    <ListGroup.Item>{user.gender}</ListGroup.Item>
                                    <ListGroup.Item>{user.educationalStatus}</ListGroup.Item>
                                    <ListGroup.Item>{user.job}</ListGroup.Item>
                                    <ListGroup.Item>{user.maritialStatus}</ListGroup.Item>
                                    <ListGroup.Item>{user.email}</ListGroup.Item>
                                    <ListGroup.Item>{user.userPhoneNumber1}</ListGroup.Item>
                                    <ListGroup.Item>{user.userPhoneNumber2}</ListGroup.Item>
                                </ListGroup>
                            </Accordion.Body>
                        </Accordion.Item>

                    </Accordion>

                ))}
            </div>
        );
    }
}
export default UserListPage;
