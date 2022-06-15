import React from "react";
import { Accordion, Button, Card, ListGroup, ListGroupItem, Table } from "react-bootstrap";
import HomeService from "../../api/HomeService";


class ListPassiveHomesPage extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            passiveHomeList: [],

        }

    }

    componentDidMount() {
        this.getPassiveHomeList();
    }

    getPassiveHomeList() {
        HomeService.listPassiveHomes().then(response => this.handlerResponse(response)).catch(error => this.handleError(error));
    }

    handlerResponse(response) {
        this.setState({ passiveHomeList: response.data })
    }

    handleError(error) {
        console.log("Listelenirken hata oluştu");
    }

    handleSetStatusActive(id){
        HomeService.setTenantHomeStatusActive(id).then(response => this.handlerSetStatusActiveResponse(response)).catch(error => this.handleSetStatusActiveError(error));
    }

    handlerSetStatusActiveResponse(response){
        this.componentDidMount();
    }

    handleSetStatusActiveError(error){
        console.log("Aktifleştirme işlemi yapılamadı!");
    }


    render() {


        return (
            <div className="row p-1">


                <Table striped bordered hover>
                    <thead>
                        <tr>
                            <th>Kiracı Adı-Soyadı</th>
                            <th>Ev Adresi</th>
                        </tr>
                    </thead>
                    <tbody>

                        {this.state.passiveHomeList.map((home, i) => (
                            <tr key={i}>

                                <td>{home.tenantName} {home.tenantSurname}</td>
                                <td>{home.country} / {home.city} / {home.district} , {home.neighborhood} Mahallesi, {home.street} Caddesi,
                                    Bina No : {home.buildingNo}</td>

                                <td><Button style={{ marginLeft: "10px" }}
                                    className="btn btn-active" onClick={() => { this.handleSetStatusActive(home.tenantHomeId)}}>Onayla</Button></td>
                            </tr>
                        ))}
                    </tbody>
                </Table>



            </div>
        );
    }
}
export default ListPassiveHomesPage;
