import React from "react";
import { Card, ListGroup, ListGroupItem } from "react-bootstrap";
import HomeService from "../../api/HomeService";


class HomeListPage extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            homeList: []
        }
    }

    componentDidMount() {
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

    render() {

        return (
            <div className="row col-md-12 offset-md-1">

                {this.state.homeList.map((home, i) => (

                    <Card style={{ width: '18rem', margin: '2rem' }} key={i}>
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
                            <Card.Link href="#">Daha Fazla</Card.Link>
                        </Card.Body>
                    </Card>

                ))}

            </div>
        );
    }
}
export default HomeListPage;