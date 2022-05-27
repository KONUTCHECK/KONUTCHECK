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
    handleDeleteUser(user) {
        console.log(user);

        UserService.deleteUser(user.id).then(response => this.handlerDeleteResponse(response)).catch(error => this.handleDeleteError(error));

    }

    handlerDeleteResponse(response) {
        this.componentDidMount();
    }

    handleDeleteError(error) {
        console.log("Kullanıcı silinirken hata oluştu");
    }

    render() {

        return (
            <div className="row col-md-12 offset-md-1">
                
                {this.state.userList.map((user, i) => (
            <Accordion>
            <Accordion.Item eventKey="0">
              <Accordion.Header>{user.name} {user.surname}</Accordion.Header>
              <Accordion.Header>{user.userType}</Accordion.Header>
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
            <ListGroup.Item>{user.password}</ListGroup.Item>
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
