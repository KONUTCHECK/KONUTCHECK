import React from "react";
import { Card, CardGroup } from "react-bootstrap";

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
                        <Card.Img variant="top" src="holder.js/100px160" />
                        <Card.Body>
                            <Card.Title>Misyonumuz</Card.Title>
                            <Card.Text>
                                  KONUTCHECK olarak ev kiralama hizmetini ve sonrasını kullanıcılarına en iyi şekilde sunmak.  
                            </Card.Text>
                        </Card.Body>
                    </Card>
                    <Card>
                        <Card.Img variant="top" src="holder.js/100px160" />
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
                        <Card.Img variant="top" src="holder.js/100px160" />
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