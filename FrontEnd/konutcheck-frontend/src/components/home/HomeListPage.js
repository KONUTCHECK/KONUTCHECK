import React from "react";
import { Button, Card, ListGroup, ListGroupItem, NavLink } from "react-bootstrap";
import HomeService from "../../api/HomeService";
import { Link } from 'react-router-dom';
import HomeFilterPage from "./HomeFilterPage";
import { ButtonGroup, Dropdown, DropdownButton } from "react-bootstrap";
import HomeTypes from "../general/combobox/HomeCombobox/HomeTypes";
import Cities from "../general/combobox/HomeCombobox/Cities";




class HomeListPage extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            homeList: [],
            homeType: "",
            amount1: "",
            amount2: "",
            city: ""
        }

        this.handlerChange = this.handlerChange.bind(this);

    }

    componentDidMount() {
        this.setState({ homeType: "Daire" })
        this.getHomeList();
    }

    getHomeList() {
        HomeService.findAllHomes().then(response => this.handlerResponse(response)).catch(error => this.handleError(error));
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

    getHomeListByType() {
        HomeService.getHomeByType("Villa").then(response => this.handlerResponse(response)).catch(error => this.handleError(error));
    }

    handleSearch() {
        HomeService.getHomeByType(this.state.homeType).then(response => this.handlerResponse(response))
            .catch(error => this.handleError(error))

        HomeService.getHomeBetweenAmounts(this.state.amount1, this.state.amount2).then(response => this.handlerResponse(response))
            .catch(error => this.handleError(error))
        
        HomeService.getHomeByCity(this.state.city).then(response => this.handlerResponse(response))
            .catch(error => this.handleError(error))
    }

    handlerChange(event) {

        this.setState({ [event.target.name]: event.target.value })
        console.log(this.state)
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
                <div className="row">
                    <div className="col-sm-3">
                        Ev Tipi
                        <HomeTypes
                            type="combobox"
                            value={this.state.homeType}
                            fieldName="homeType"
                            onChange={this.handlerChange}
                        >
                        </HomeTypes>
                    </div>

                    <div className="col-sm-3">
                        Fiyat Aralığı
                        <div className="row">
                            <div className="col-md-6" >
                                <input
                                    type="text"
                                    className="form-control"
                                    placeholder="İlk Fiyat"
                                    required=""
                                    autoFocus=""
                                    value={this.state.amount1}
                                    name="amount1"
                                    onChange={this.handlerChange}
                                />
                            </div>
                            <div className="col-md-6" >
                                <input
                                    type="text"
                                    className="form-control"
                                    placeholder="Son Fiyat"
                                    required=""
                                    autoFocus=""
                                    value={this.state.amount2}
                                    name="amount2"
                                    onChange={this.handlerChange}
                                />
                            </div>
                        </div>
                    </div>

                    <div className="col-sm-3">
                        Şehir
                    <Cities
                            type="combobox"
                            value={this.state.city}
                            fieldName="city"
                            onChange={this.handlerChange}
                        >
                        </Cities>
                    </div>
                    <div className="col-sm-3">
                        <div className="d-grid gap-2">
                            <Button variant="secondary" onClick={() => this.handleSearch()} onChange={this.handlerChange}>Arama</Button>
                        </div>

                    </div>
                </div>

                {this.state.homeList.map((home, i) => (
                    <Card className="my-card" style={{ width: '18rem', margin: '2rem' }} key={i}>
                        <Button className="btn-light add-tenant">➕</Button>
                        <Card.Img variant="top" src="holder.js/100px180?text=Image cap" />
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
                            <Button style={{ marginLeft: "10px" }} onClick={() => this.handleDeleteHome(home)} className="btn btn-info">Delete</Button>


                            <Link to='/update-home-infos'>
                                <Button style={{ marginLeft: "10px" }} className="btn btn-info" onClick={() => this.setData(home)}>Güncelle</Button>
                            </Link>
                        </Card.Body>
                    </Card>
                ))}

            </div>
        );
    }
}
export default HomeListPage;