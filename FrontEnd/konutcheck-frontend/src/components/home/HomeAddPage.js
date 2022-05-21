import React from "react";
import HomeService from "../../api/HomeService";
import serialize from 'form-serialize';
import WarningSystemType from "../general/combobox/HomeCombobox/WarningSystemType";
import HomeTypes from "../general/combobox/HomeCombobox/HomeTypes";
import HomeAspects from "../general/combobox/HomeCombobox/HomeAspects";
import Countries from "../general/combobox/HomeCombobox/Countries";
import Cities from "../general/combobox/HomeCombobox/Cities";




class HomeAddPage extends React.Component {

    handleFormSubmit = (e) => {
        e.preventDefault();
        const newHome = serialize(e.target, { hash: true })

        this.save(newHome);
    }

    save(newHome) {

        HomeService.saveHome(newHome)
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
                            <label htmlFor="inputRating">Fiyat</label>
                            <input
                                className="form-control "

                                name="amount" />
                        </div>

                        <div className="form-group ">
                            <label htmlFor="inputRating">Depozit</label>
                            <input
                                className="form-control "

                                name="deposit" />
                        </div>

                        <div className="form-group ">
                            <label htmlFor="inputRating">Aidat</label>
                            <input
                                className="form-control "

                                name="dues" />
                        </div>

                        <div className="form-group ">
                            <label htmlFor="inputRating">Oda Sayısı</label>
                            <input
                                className="form-control "

                                name="numberOfRooms" />
                        </div>

                        <div className="form-group ">
                            <label htmlFor="inputRating">Isınma Şekli</label>
                            <WarningSystemType
                                fieldName="warningSystem"
                                notNull={true}
                            ></WarningSystemType>
                        </div>

                        <div className="form-group ">
                            <label htmlFor="inputRating">Bina Yaşı</label>
                            <input
                                className="form-control "

                                name="buildingAge" />
                        </div>

                        <div className="form-group ">
                            <label htmlFor="inputRating">Cephe</label>
                            <HomeAspects
                                fieldName="homeAspect"
                                notNull={true}
                            ></HomeAspects>
                        </div>

                        <div className="form-group ">
                            <label htmlFor="inputRating">Kat</label>
                            <input
                                className="form-control "

                                name="floor" />
                        </div>

                        <div className="form-group ">
                            <label htmlFor="inputRating">Metrekare</label>
                            <input
                                className="form-control "

                                name="homeSize" />
                        </div>

                        <div className="form-group ">
                            <label htmlFor="inputRating">Ev Tipi</label>
                            <HomeTypes
                                fieldName="homeType"
                                notNull={true}
                            ></HomeTypes>
                        </div>

                        <div className="form-group ">
                            <label htmlFor="inputRating">Ülke</label>
                            <Countries
                                fieldName="country"
                                notNull={true}
                            ></Countries>
                        </div>

                        <div className="form-group ">
                            <label htmlFor="inputRating">Şehir</label>
                            <Cities
                                fieldName="city"
                                notNull={true}
                            ></Cities>
                        </div>

                        <div className="form-group ">
                            <label htmlFor="inputRating">İlçe</label>
                            <input
                                className="form-control "

                                name="district" />
                        </div>

                        <div className="form-group ">
                            <label htmlFor="inputRating">Mahalle</label>
                            <input
                                className="form-control "

                                name="neighborhood" />
                        </div>

                        <div className="form-group ">
                            <label htmlFor="inputRating">Sokak</label>
                            <input
                                className="form-control "

                                name="street" />
                        </div>

                        <div className="form-group ">
                            <label htmlFor="inputRating">Bina No</label>
                            <input
                                className="form-control "

                                name="buildingNo" />
                        </div>

                        <div className="form-group ">
                            <label htmlFor="inputRating">İç Kapı No</label>
                            <input
                                className="form-control "

                                name="apartmentNo" />
                        </div>

                    </div>

                    <input type="submit" className="btn btn-danger btn-block" value="Kaydet" />
                </form>
            </div>

        );


    }

}
export default HomeAddPage;