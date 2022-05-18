import React from "react";
import PageTitle from "../general/pageTitle";

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
                <PageTitle title="Aradığınız sayfa bulunamadı!"></PageTitle>
            </div>
        );
    }
}

export default ErrorPage;