import React from "react";
import Container from "./container";
import Slider from "./slider";

class HomePage extends React.Component{
    constructor(props) {
        super(props);

        this.state = {
            testState : "initialState"
        }

    }

    handleClick(){
        this.setState({testState: "newState"})
    }

    render(){
        return(
            <div> 
                <Slider></Slider>
                <Container>
                    
                </Container>
            </div>
        );
    }
}

export default HomePage;