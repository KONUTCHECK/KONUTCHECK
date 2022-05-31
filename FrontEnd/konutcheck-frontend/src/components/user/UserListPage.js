import React from "react";
import { Accordion, ListGroup } from "react-bootstrap";
import UserService from "../../api/UserService";


class UserListPage extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            userList: []
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


    render() {

        return (
            <div className="row p-1">
                {this.state.userList.map((user, i) => (
                    <Accordion key={user.id}>
                        <Accordion.Item eventKey="0">
                            <Accordion.Header>{user.name} {user.surname}{` (${user.userType})`}</Accordion.Header>
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
