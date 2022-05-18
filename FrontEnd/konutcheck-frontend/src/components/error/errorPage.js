import React from "react";

class ErrorPage extends React.Component{
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
                <h1>ERROR!!</h1>
            </div>
        );
    }
}

export default ErrorPage;