import React from "react";
import { Button, Card, ListGroup, ListGroupItem, NavLink, OverlayTrigger, Tooltip } from "react-bootstrap";
import HomeService from "../../api/HomeService";
import { Link } from 'react-router-dom';




class TenantHomesDetailPage extends React.Component {

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
        HomeService.getTenantHomeDetails().then(response => this.handlerResponse(response)).catch(error => this.handleError(error));
    }

    handlerResponse(response) {
        this.setState({ homeList: response.data })
    }

    handleError(error) {
        console.log("Evler çekilirken hata oluştu");
    }


    render() {

        return (
            <div className="row" style={{ margin: '10px 15px 15px 0' }}>
              <p className="my-homes"><b>KİRACI OLDUĞUM EVLER</b></p> 
                {this.state.homeList.map((home, i) => (
                    <Card className="my-card" style={{ width: '100%' }} key={i}>
                        <Card.Body>
                            <Card.Title>{home.homeType}</Card.Title>
                            <Card.Text>
                                {home.city} / {home.district} , {home.neighborhood} Mahallesi, {home.street} Caddesi,
                                Bina No : {home.buildingNo}
                            </Card.Text>
                        </Card.Body>
                        <ListGroup className="list-group-flush">
                        <ListGroupItem> <b>Fiyat :</b> {home.amount}</ListGroupItem>
                            <ListGroupItem><b>Depozito : </b>{home.deposit}</ListGroupItem>
                            <ListGroupItem><b>Oda Sayısı : </b> {home.numberOfRooms}</ListGroupItem>
                            <ListGroupItem><b>Kat Sayısı : </b>{home.floor}</ListGroupItem>
                            <ListGroupItem><b>Isınma Tipi : </b>{home.warningSystem}</ListGroupItem>
                            <ListGroupItem><b>Cephe : </b>{home.homeAspect}</ListGroupItem>
                            <ListGroupItem><b>Metrekare :</b> {home.homeSize}</ListGroupItem>
                            <ListGroupItem><b>Bina Yaşı :</b> {home.buildingAge}</ListGroupItem>
                            <ListGroupItem><b>Aidat :</b> {home.dues}</ListGroupItem>
                            <ListGroupItem><b>İlan Tarihi : </b>{home.announcementDate}</ListGroupItem>
                        </ListGroup>
                        <Card.Body>
                            <Link to={`/home-evaluation?id=${home.id}`}>
                                <Button style={{ width: "100%" }} className="btn">Evi Değerlendir</Button>
                            </Link>

                            <Link to='/landlord-evaluation'>
                                <Button style={{ width: "100%" }} className="btn" >Ev Sahibini Değerlendir</Button>
                            </Link>

                        </Card.Body>
                    </Card>
                ))
                }

            </div>
        );
    }
}
export default TenantHomesDetailPage;