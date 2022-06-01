import React from "react";
import { Navigate } from "react-router-dom";
import AuthenticationService from "../../api/AuthenticationService";
import PageTitle from "../general/pageTitle";
import image from "../homePage/img/logooo.png";

class LoginPage extends React.Component{
    constructor(props) {
        super(props);

        this.state = {
            email:"",
            password:"",
        }

        this.handlerChange = this.handlerChange.bind(this);
    }

    handlerChange(event){
        this.setState({[event.target.name]: event.target.value})
    }

    handleFormSubmit = (e) => {
        e.preventDefault();
        AuthenticationService.login(this.state.email, this.state.password)
            .then(response => this.handleResponse(response))
            .catch(error => this.handleError(error))
    }

    handleResponse(response){
        console.log(response)
        sessionStorage.setItem('token', response.data)
        sessionStorage.setItem('email', this.state.email)
        this.props.login();
    }

    handleError(error){
        console.log(error)
    }

    render(){

        if(sessionStorage.getItem('token')){
            return <Navigate to='/'></Navigate>
        }

        return(
            <div> 
                <div className="container">
                <div className="text-center mt-5">
                    <div className="row col-md-4 offset-md-4">

                        <form className="form-signin" onSubmit={this.handleFormSubmit}>

                            <img className="mb-4" 
                            src= {image} 
                            alt="" width="122" height="72" />
                            <h1 className="h3 mb-3 font-weight-normal">Giriş</h1>

                          
                            <label htmlFor="inputEmail" className="sr-only">Email Adresi</label>
                            <input
                                placeholder="Email adresinizi giriniz..."
                                type="email"
                                id="inputEmail"
                                className="form-control"
                                required=""
                                autoFocus=""
                                value={this.state.identityNo}
                                name="email"
                                onChange={this.handlerChange}
                            />
                         
                            <label htmlFor="inputPassword" className="sr-only">Şifre</label>
                            <input
                                placeholder="Şifrenizi giriniz..."
                                type="password"
                                id="inputPassword"
                                className="form-control"
                                required=""
                                value={this.state.password}
                                name="password"
                                onChange={this.handlerChange}
                            />

                            <div className="checkbox mb-3">
                                <label>
                                    <input type="checkbox" value="remember-me" /> Beni Hatırla
                                </label>
                            </div>

                            <input type="submit" className="btn btn-danger btn-block" value="Giriş Yap" />
                        </form>
                    </div>
                </div>
            </div>
            </div>
        );
    }
}

export default LoginPage;