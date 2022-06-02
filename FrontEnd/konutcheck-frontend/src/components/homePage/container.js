import React from "react";
import { Card, CardGroup } from "react-bootstrap";
import mission from "./img/mission.png";
import vission from "./img/vission.png";
import whyus from "./img/whyus.png";

class Container extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            testState: "initialState"
        }

    }

    handleClick() {
        this.setState({ testState: "newState" })
    }

    render() {
        return (
            <div>
                <CardGroup className="cardgroup">
                    <Card>
                        <Card.Img variant="top" src={mission} className="card-img"/>
                        <Card.Body>
                            <Card.Title>Misyonumuz</Card.Title>
                            <Card.Text>
                                  KONUTCHECK olarak ev kiralama hizmetini ve sonrasını kullanıcılarına en iyi şekilde sunmak.  
                            </Card.Text>
                        </Card.Body>
                    </Card>
                    <Card>
                        <Card.Img variant="top" src={vission} className="card-img" />
                        <Card.Body>
                            <Card.Title>Vizyonumuz</Card.Title>
                            <Card.Text>
                                  Kalite standartlarını, kullanıcıya uygun bir şekilde geliştirip, yükselterek gayrimenkul
                                 sektöründe yerimizi alıp iyi bir konuma gelmek ve kullanıcılarımızın kiralama hizmetinde
                                  yaşadığı sorunlara çözüm bulmak.{' '}
                            </Card.Text>
                        </Card.Body>
                    </Card>
                    <Card>
                        <Card.Img variant="top" src={whyus} className="card-img" />
                        <Card.Body>
                            <Card.Title>Neden Biz?</Card.Title>
                            <Card.Text>
                                  Siz değerli kullanıcılarımıza, ev kiralarken ya da evinizi kiralarken yaşayabileceğiniz tüm sorunları 
                                ve ikilemleri çözerek huzur ve güven ortamında kiralama hizmeti sağlayabiliriz.
                            </Card.Text>
                        </Card.Body>
                    </Card>
                </CardGroup>

                
    
            </div>
        );
    }
}

export default Container;