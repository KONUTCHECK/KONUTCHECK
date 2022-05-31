import React from "react";
import { Carousel } from "react-bootstrap";
import image from "./img/morev.png";
import Image from "./img/ev.png";




class Slider extends React.Component {

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
                <Carousel>
                    <Carousel.Item interval={1000}>
                        <img
                            className="d-block w-100"
                            src= {image}
                            alt="First slide"
                        />
                        <Carousel.Caption>
                            <h3 className="slider-title">KONUTCHECK</h3>
                            <p className="slider-p">TEK TIKLA 'EV'LENİN</p>
                        </Carousel.Caption>
                    </Carousel.Item>
                    <Carousel.Item interval={500}>
                        <img
                            className="d-block w-100"
                            src= {Image}
                            alt="Second slide"
                        />
                        <Carousel.Caption>
                            <h3 className="slider-title">KONUTCHECK</h3>
                            <p className="slider-p">'EV'LENECEKSEN GEL</p>
                        </Carousel.Caption>
                    </Carousel.Item>
                </Carousel>
            </div>
        );
    }
}

export default Slider;
