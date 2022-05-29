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
                            <p>Tek tıkla 'ev'lenin</p>
                        </Carousel.Caption>
                    </Carousel.Item>
                    <Carousel.Item interval={500}>
                        <img
                            className="d-block w-100"
                            src= {Image}
                            alt="Second slide"
                        />
                        <Carousel.Caption>
                            <h3 className="slider-title">Second slide label</h3>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                        </Carousel.Caption>
                    </Carousel.Item>
                    <Carousel.Item>
                        <img
                            className="d-block w-100"
                            src={image}
                            alt="Third slide"
                        />
                        <Carousel.Caption>
                            <h3 className="slider-title">Third slide label</h3>
                            <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p>
                        </Carousel.Caption>
                    </Carousel.Item>
                </Carousel>
            </div>
        );
    }
}

export default Slider;
