import React from "react";
import { Button, Card, ListGroup, ListGroupItem, NavLink, OverlayTrigger, Tooltip } from "react-bootstrap";
import HomeService from "../../api/HomeService";
import { Link } from 'react-router-dom';
import HomeFilterPage from "./HomeFilterPage";
import { ButtonGroup, Dropdown, DropdownButton } from "react-bootstrap";
import HomeTypes from "../general/combobox/HomeCombobox/HomeTypes";
import Cities from "../general/combobox/HomeCombobox/Cities";
import 'react-confirm-alert/src/react-confirm-alert.css';
import { confirmAlert } from 'react-confirm-alert';

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
            <div className="row" style={{ margin: '10px 15px 15px 0' }}>
                <p className="my-homes"><b>EVLERİM</b></p>
                {this.state.homeList.map((home, i) => (
                    <Card className="my-card" style={{ width: '100%' }} key={i}>

                        <Card.Body>
                            <Card.Title>{home.homeType}</Card.Title>
                            <Card.Text>
                                {home.city} / {home.district} , {home.neighborhood} Mahallesi, {home.street} Caddesi, Bina No: {home.buildingNo}
                            </Card.Text>
                        </Card.Body>
                        <ListGroup className="list-group-flush">
                            <ListGroupItem> <b>Fiyat :</b> {home.amount}</ListGroupItem>
                            <ListGroupItem><b>Depozito : </b>{home.deposit}</ListGroupItem>
                            <ListGroupItem><b>Oda Sayısı :</b> {home.numberOfRooms}</ListGroupItem>
                            <ListGroupItem><b>Kat Sayısı :</b>{home.floor}</ListGroupItem>
                            <ListGroupItem><b>Isınma Tipi : </b>{home.warningSystem}</ListGroupItem>
                            <ListGroupItem><b>Cephe : </b>{home.homeAspect}</ListGroupItem>
                            <ListGroupItem><b>Metrekare :</b> {home.homeSize}</ListGroupItem>
                            <ListGroupItem><b>Bina Yaşı :</b> {home.buildingAge}</ListGroupItem>
                            <ListGroupItem><b>Aidat :</b> {home.dues}</ListGroupItem>
                            <ListGroupItem><b>İlan Tarihi : </b>{home.announcementDate}</ListGroupItem>
                        </ListGroup>
                        <Card.Body>
                            <Button style={{ float: "left" }} onClick={() => {
                                const confirmBox = window.confirm(
                                    "Bu evi silmek istediğine emin misin?"
                                )
                                if (confirmBox === true) {
                                    this.handleDeleteHome(home)
                                }
                            }
                            } className="btn-danger">Sil</Button>


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