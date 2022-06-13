import axios from "axios";
import React from "react";
import { Navigate } from "react-router-dom";
import AuthenticationService from "../../api/AuthenticationService";
import UserService from "../../api/UserService";
import PageTitle from "../general/pageTitle";
import image from "../homePage/img/logooo.png";
import ToastMessage from "../general/toastMessage";


class LoginPage extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            email: "",
            password: "",
            toast: false,
            type: 'success',
            message: 'E-posta adresi veya şifre yanlış!'
        }

        this.handlerChange = this.handlerChange.bind(this);
    }

    handlerChange(event) {
        this.setState({ [event.target.name]: event.target.value })
    }

    handleFormSubmit = (e) => {
        e.preventDefault();
        AuthenticationService.login(this.state.email, this.state.password)
            .then(response => this.handleResponse(response))
            .catch(error => this.handleError(error))
    }

    handleResponse(response) {
        console.log(response)
        sessionStorage.setItem('token', response.data)
        sessionStorage.setItem('email', this.state.email)
        axios.defaults.headers.common['Authorization'] = sessionStorage.getItem('token');
        UserService.getUserInfo().then(response => {
            sessionStorage.setItem('userType', response.data.userType)
            sessionStorage.setItem('userId', response.data.id)
            this.props.login()
        }).catch(error => console.log(error));

    }

    handleError(error) {
        this.setState({
            toast: true,
            type: 'error',
            message: "E-posta adresi veya şifre yanlış!"
        })
        setTimeout(() => {
            this.setState({ toast: false })
        }, 100);
        console.log(error)
    }

    render() {

        if (sessionStorage.getItem('token')) {
            return <Navigate to='/'></Navigate>
        }

        return (
            <div>
                <div className="container">
                    <div className="text-center mt-5">
                        <div className="row col-md-4 offset-md-4">

                            <form className="form-signin" onSubmit={this.handleFormSubmit}>

                                <img className="mb-4"
                                    src={image}
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


                                <input type="submit" className="btn btn-danger btn-block" value="Giriş Yap" />
                            </form>
                        </div>
                    </div>
                </div>
                {this.state.toast &&
                    <ToastMessage type={this.state.type} message={this.state.message}></ToastMessage>
                }
            </div>
        );
    }
}

export default LoginPage;