import React from "react";
import { Accordion, Button, Card, ListGroup, ListGroupItem, Table } from "react-bootstrap";
import { Link } from "react-router-dom";
import HomeService from "../../api/HomeService";

/*This page lists the landlord's tenants. */

class ListLandlordsTenantsPage extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            tenantList: [],

        }

    }

    componentDidMount() {
        this.getTenantList();
    }

    getTenantList() {
        HomeService.listLandlordTenants().then(response => this.handlerResponse(response)).catch(error => this.handleError(error));
    }

    handlerResponse(response) {
        this.setState({ tenantList: response.data })
        console.log(this.state.tenantList);
    }

    handleError(error) {
        console.log("Listelenirken hata oluştu");
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

                        {this.state.tenantList.map((home, i) => (
                            <tr key={i}>

                                <td>{home.tenantName} {home.tenantSurname}</td>
                                <td>{home.country} / {home.city} / {home.district} , {home.neighborhood} Mahallesi, {home.street} Caddesi,
                                    Bina No : {home.buildingNo}</td>

                                <td>
                                <Link to="/tenant-evaluation/">
                                    <Button style={{ marginLeft: "10px" }}
                                    className="btn btn-info">Kiracıyı Değerlendir</Button>
                                </Link>
                                </td>

                            </tr>
                        ))}
                    </tbody>
                </Table>



            </div>
        );
    }
}
export default ListLandlordsTenantsPage;
