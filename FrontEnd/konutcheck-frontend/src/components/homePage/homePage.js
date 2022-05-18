import React from "react";

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
            <div>HOME PAGE </div>
        );
    }
}

export default HomePage;