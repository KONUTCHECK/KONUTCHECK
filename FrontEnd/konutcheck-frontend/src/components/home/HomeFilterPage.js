import React from "react";
import { Button, ButtonGroup, Dropdown, DropdownButton } from "react-bootstrap";
import HomeTypes from "../general/combobox/HomeCombobox/HomeTypes";
import HomeService from "../../api/HomeService";
import { Card, ListGroup, ListGroupItem, NavLink } from "react-bootstrap";



class HomeFilterPage extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            home: [],
            homeType: ""
        }

        this.handlerChange = this.handlerChange.bind(this);
    }

    componentDidMount() {
        this.getHomeList();
    }

    getHomeList() {
        HomeService.getHomeByType("Villa").then(response => this.handleResponse(response))
            .catch(error => this.handleError(error))
    }

    handleResponse(response) {
        this.setState({ homeList: response.data })
    }

    handleError(error) {
        console.log("evler çekilirken hata oluştu");
    }

    handleSearch() {
        HomeService.getHomeByType().then(response => this.handleResponse(response))
            .catch(error => this.handleError(error))
    }

    handlerChange(event) {

        this.setState({ [event.target.name]: event.target.value })

        console.log(this.state)
    }

    render() {
        return (
            <div>
                <ButtonGroup>
                    <Button>
                        <HomeTypes
                            fieldName="homeType"
                            notNull={true}
                            value={this.state.homeType}
                            name="homeTypes"
                            onChange={this.handlerChange}
                        ></HomeTypes>
                    </Button>
                    <Button>2</Button>

                    <DropdownButton as={ButtonGroup} title="Dropdown" id="bg-nested-dropdown">
                        <Dropdown.Item eventKey="1">Dropdown link</Dropdown.Item>
                        <Dropdown.Item eventKey="2">Dropdown link</Dropdown.Item>
                    </DropdownButton>

                    <Button onClick={() => this.handleSearch()}>Arama</Button>

                   

                </ButtonGroup>
            </div>
        );
    }
}

export default HomeFilterPage;