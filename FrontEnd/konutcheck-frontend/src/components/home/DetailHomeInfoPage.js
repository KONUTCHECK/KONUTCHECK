import React, { Component } from 'react'
import HomeService from '../../api/HomeService'

class DetailHomeInfoPage extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            home: {}
        }
    }

    componentDidMount(){
        HomeService.getHomeById(this.state.id).then( res => {
            this.setState({home: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Employee Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> Employee First Name: </label>
                            <div> { this.state.home.amount }</div>
                        </div>
                        <div className = "row">
                            <label> Employee Last Name: </label>
                            <div> { this.state.home.floor }</div>
                        </div>
                        <div className = "row">
                            <label> Employee Email ID: </label>
                            <div> { this.state.home.deposit }</div>
                        </div>
                    </div>

                </div>
            </div>
        )
    }
}

export default DetailHomeInfoPage