import React from "react";
import { Link, Navigate } from "react-router-dom";
import AuthenticationService from "../../api/AuthenticationService";
import serialize from 'form-serialize';
import Usertype from "../general/combobox/RegisterCombobox/Usertype";
import Gender from "../general/combobox/RegisterCombobox/Gender";
import Marital_status from "../general/combobox/RegisterCombobox/marital_status";
import Education from "../general/combobox/RegisterCombobox/education";



class Register extends React.Component {

    handleFormSubmit = (e) => {
        e.preventDefault();
        const newUser = serialize(e.target, { hash: true })

        this.save(newUser);
    }

    save(newUser) {

        AuthenticationService.saveUser(newUser)
            .then(response => this.handleResponse(response))
            .catch(error => this.handleError(error))
    }

    handleResponse(response) {

        console.log(response);
    }

    handleError(error) {
        console.log(error.data);
    }

    render() {
       

        return (

            <div className="container col-md-6 offset-md-3">

                <form id="product-form" className="mt-5" onSubmit={this.handleFormSubmit}>

                    <div className="form-row">

                        <div className="form-group ">
                            <label htmlFor="inputRating">Ad</label>
                            <input
                                className="form-control"

                                name="name" />
                        </div>

                        <div className="form-group ">
                            <label htmlFor="inputRating">Soyad</label>
                            <input
                                className="form-control "

                                name="surname" />
                        </div>

                        <div className="form-group ">
                            <label htmlFor="inputRating">Kullanıcı Tipi</label>
                            <Usertype
                                fieldName="userType"
                                notNull={true}
                            ></Usertype>
                        </div>

                        <div className="form-group ">
                            <label htmlFor="inputRating">Yaş</label>
                            <input
                                className="form-control "

                                name="age" />
                        </div>

                        <div className="form-group ">
                            <label htmlFor="inputRating">Cinsiyet</label>
                            <Gender
                                fieldName="gender"
                                notNull={true}
                            ></Gender>
                        </div>

                        <div className="form-group ">
                            <label htmlFor="inputRating">Eğitim Durumu</label>
                            <Education
                                fieldName="educationalStatus"
                                notNull={true}
                            ></Education>
                        </div>

                        <div className="form-group ">
                            <label htmlFor="inputRating">Medeni Durumu</label>
                            <Marital_status
                                fieldName="maritialStatus"
                                notNull={true}
                            ></Marital_status>
                        </div>

                        <div className="form-group ">
                            <label htmlFor="inputRating">Çalıştığı Sektör</label>
                            <input
                                className="form-control "

                                name="job" />
                            
                        </div>

                        <div className="form-group ">
                            <label htmlFor="inputRating">Telefon Numarası</label>
                            <input
                                className="form-control "

                                name="userPhoneNumber1" />
                        </div>
                        <div className="form-group ">
                            <label htmlFor="inputRating">2. Telefon Numarası</label>
                            <input
                                className="form-control "

                                name="userPhoneNumber2" />
                        </div>

                        <div className="form-group ">
                            <label htmlFor="inputRating">Email Adresi</label>
                            <input
                                className="form-control "

                                name="email" />
                          
                        </div>

                        <div className="form-group ">
                            <label htmlFor="inputRating">Şifre</label>
                            <input
                                className="form-control "

                                name="password" />
                            
                        </div>

                    </div>
                    
                    <input type="submit" className="btn btn-danger btn-block" value="Kaydet" />
                    
                </form>
            </div>

        );


    }

}
export default Register;