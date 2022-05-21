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
                <CardGroup>
                    <Card>
                        <Card.Img variant="top" src="holder.js/100px160" />
                        <Card.Body>
                            <Card.Title>Card title</Card.Title>
                            <Card.Text>
                                This is a wider card with supporting text below as a natural lead-in to
                                additional content. This content is a little bit longer.
                            </Card.Text>
                        </Card.Body>
                    </Card>
                    <Card>
                        <Card.Img variant="top" src="holder.js/100px160" />
                        <Card.Body>
                            <Card.Title>Card title</Card.Title>
                            <Card.Text>
                                This card has supporting text below as a natural lead-in to additional
                                content.{' '}
                            </Card.Text>
                        </Card.Body>
                    </Card>
                    <Card>
                        <Card.Img variant="top" src="holder.js/100px160" />
                        <Card.Body>
                            <Card.Title>Card title</Card.Title>
                            <Card.Text>
                                This is a wider card with supporting text below as a natural lead-in to
                                additional content. This card has even longer content than the first to
                                show that equal height action.
                            </Card.Text>
                        </Card.Body>
                    </Card>
                </CardGroup>

                <footer>
        <div class="container clearfix">

            <div class="col2">
                  <h4>LOCATION</h4>
                  <p>SEOUL, Line Friends Store</p>
            </div>

            <div class="col2">
                <h4>AROUND THE WEB</h4>
                <ul>
                    <li>
                        <button class="btn-social">
                            <a href="https://www.bt21.com/character" target="_blank">
                               <i class="fab fa-google"></i>
                            </a>
                        </button>
                    </li>
                    <li>
                        <button class="btn-social">
                            <a href="https://twitter.com/bt21_" target="_blank">
                               <i class="fab fa-twitter"></i>
                            </a>
                        </button>
                    </li>
                    <li>
                        <button class="btn-social">
                            <a href="https://www.youtube.com/channel/UCINr5W7cwW06ADtsszAToAw" target="_blank">
                               <i class="fab fa-youtube"></i>
                            </a>
                        </button>
                    </li>
                </ul>
            </div>
        </div>
    </footer>
    <div class="copyright">

        <div class="container">
            <small> Copyright © Your Website 2021</small>
        </div>

    </div>
            </div>
        );
    }
}

export default Container;