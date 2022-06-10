import React from "react";
import { Button, Card, ListGroup, ListGroupItem, NavLink, OverlayTrigger, Tooltip } from "react-bootstrap";
import HomeService from "../../api/HomeService";
import { Link } from 'react-router-dom';
import HomeFilterPage from "./HomeFilterPage";
import { ButtonGroup, Dropdown, DropdownButton } from "react-bootstrap";
import HomeTypes from "../general/combobox/HomeCombobox/HomeTypes";
import Cities from "../general/combobox/HomeCombobox/Cities";

class LandlordHomesDetailPage extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            homeList: [],
        }

    }

    componentDidMount() {
        this.getHomeList();
    }

    getHomeList() {
        HomeService.getLandlordHomeDetails().then(response => this.handlerResponse(response)).catch(error => this.handleError(error));
    }

    handlerResponse(response) {
        this.setState({ homeList: response.data })
    }

    handleError(error) {
        console.log("Evler çekilirken hata oluştu");
    }

    handleDeleteHome(home) {
        console.log(home);

        HomeService.deleteHome(home.id).then(response => this.handlerDeleteResponse(response)).catch(error => this.handleDeleteError(error));

    }

    handlerDeleteResponse(response) {
        this.componentDidMount();
    }

    handleDeleteError(error) {
        console.log("Ev silinirken hata oluştu");
    }

    setData(home) {
        let { id, amount, deposit, dues, numberOfRooms, warningSystem, buildingAge, homeAspect, floor, homeSize, homeType,
            country, city, district, neighborhood, street, buildingNo, apartmentNo, announcementDate } = home;
        localStorage.setItem('id', id);
        localStorage.setItem('Fiyat', amount);
        localStorage.setItem('Depozit', deposit);
        localStorage.setItem('Aidat', dues);
        localStorage.setItem('Oda Sayısı', numberOfRooms);
        localStorage.setItem('Isınma Şekli', warningSystem);
        localStorage.setItem('Bina Yaşı', buildingAge);
        localStorage.setItem('Cephe', homeAspect);
        localStorage.setItem('Bulunduğu Kat', floor);
        localStorage.setItem('Metrekare', homeSize);
        localStorage.setItem('Ev Tipi', homeType);
        localStorage.setItem('Ülke', country);
        localStorage.setItem('Şehir', city);
        localStorage.setItem('İlçe', district);
        localStorage.setItem('Mahalle', neighborhood);
        localStorage.setItem('Sokak', street);
        localStorage.setItem('Bina No', buildingNo);
        localStorage.setItem('Kapı No', apartmentNo);
        localStorage.setItem('Son Güncelleme', announcementDate);

        console.log(home)
    }

    render() {

        return (
            <div className="row" style={{ margin: '10px 0 0 0' }}>

                {this.state.homeList.map((home, i) => (
                    <Card className="my-card" style={{ width: '18rem', margin: '2rem' }} key={i}>

                        <Card.Body>
                            <Card.Title>{home.homeType}</Card.Title>
                            <Card.Text>
                                {home.city} / {home.district} , {home.neighborhood} Mahallesi, {home.street} Caddesi,
                                Bina No : {home.buildingNo}
                            </Card.Text>
                        </Card.Body>
                        <ListGroup className="list-group-flush">
                            <ListGroupItem>Fiyat : {home.amount}</ListGroupItem>
                            <ListGroupItem>Oda Sayısı : {home.numberOfRooms}</ListGroupItem>
                            <ListGroupItem>Kat Sayısı : {home.floor}</ListGroupItem>
                            <ListGroupItem>{home.announcementDate}</ListGroupItem>
                        </ListGroup>
                        <Card.Body>
                            <Button s style={{ float: "left" }} onClick={() => this.handleDeleteHome(home)} className="btn">Delete</Button>


                            <Link to='/update-home-infos'>
                                <Button style={{ float: "right" }} className="btn" onClick={() => this.setData(home)}>Güncelle</Button>
                            </Link>
                        </Card.Body>
                    </Card>
                ))}

            </div>
        );
    }
}
export default LandlordHomesDetailPage;