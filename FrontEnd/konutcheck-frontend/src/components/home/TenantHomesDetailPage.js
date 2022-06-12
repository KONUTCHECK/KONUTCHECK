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