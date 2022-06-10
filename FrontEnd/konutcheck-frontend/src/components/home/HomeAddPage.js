import React from "react";
import HomeService from "../../api/HomeService";
import serialize from 'form-serialize';
import WarningSystemType from "../general/combobox/HomeCombobox/WarningSystemType";
import HomeTypes from "../general/combobox/HomeCombobox/HomeTypes";
import HomeAspects from "../general/combobox/HomeCombobox/HomeAspects";
import Countries from "../general/combobox/HomeCombobox/Countries";
import Cities from "../general/combobox/HomeCombobox/Cities";
import ToastMessage from "../general/toastMessage";




class HomeAddPage extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            toast: false,
            type: 'success',
            message: 'Ev Başarı ile Eklendi.'
        }
    }
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
        this.setState({
            toast: true,
            type: 'success',
            message: 'Ev Başarı ile Eklendi.'
        })
        setTimeout(() => {
            this.setState({ toast: false })
        }, 100);
        console.log(response);
    }

    handleError(error) {
        this.setState({
            toast: true,
            type: 'error',
            message: error.message
        })
        setTimeout(() => {
            this.setState({ toast: false })
        }, 100);
        console.log(error.data);
    }

    render() {
        return (

            <div className="container col-md-6 offset-md-3">

                <form id="product-form" className="mt-5" onSubmit={this.handleFormSubmit}>

                    <div className="form-row">

                        <div className="form-group ">
                            <label htmlFor="inputRating" className="label-name">Fiyat</label>
                            <input
                                className="form-control "

                                name="amount" />
                        </div>

                        <div className="form-group ">
                            <label htmlFor="inputRating" className="label-name">Depozit</label>
                            <input
                                className="form-control "

                                name="deposit" />
                        </div>

                        <div className="form-group ">
                            <label htmlFor="inputRating" className="label-name">Aidat</label>
                            <input
                                className="form-control "

                                name="dues" />
                        </div>

                        <div className="form-group ">
                            <label htmlFor="inputRating" className="label-name">Oda Sayısı</label>
                            <input
                                className="form-control "

                                name="numberOfRooms" />
                        </div>

                        <div className="form-group ">
                            <label htmlFor="inputRating" className="label-name">Isınma Şekli</label>
                            <WarningSystemType
                                fieldName="warningSystem"
                                notNull={true}
                                type="combobox"
                            ></WarningSystemType>
                        </div>

                        <div className="form-group ">
                            <label htmlFor="inputRating" className="label-name">Bina Yaşı</label>
                            <input
                                className="form-control "

                                name="buildingAge" />
                        </div>

                        <div className="form-group ">
                            <label htmlFor="inputRating" className="label-name">Cephe</label>
                            <HomeAspects
                                fieldName="homeAspect"
                                notNull={true}
                                type="combobox"
                            ></HomeAspects>
                        </div>

                        <div className="form-group ">
                            <label htmlFor="inputRating" className="label-name">Kat</label>
                            <input
                                className="form-control "

                                name="floor" />
                        </div>

                        <div className="form-group ">
                            <label htmlFor="inputRating" className="label-name">Metrekare</label>
                            <input
                                className="form-control "

                                name="homeSize" />
                        </div>

                        <div className="form-group ">
                            <label htmlFor="inputRating" className="label-name">Ev Tipi</label>
                            <HomeTypes
                                fieldName="homeType"
                                notNull={true}
                                type="combobox"
                            ></HomeTypes>
                        </div>

                        <div className="form-group ">
                            <label htmlFor="inputRating" className="label-name">Ülke</label>
                            <Countries
                                fieldName="country"
                                notNull={true}
                                type="combobox"
                            ></Countries>
                        </div>

                        <div className="form-group ">
                            <label htmlFor="inputRating" className="label-name">Şehir</label>
                            <Cities
                                fieldName="city"
                                notNull={true}
                            ></Cities>
                        </div>

                        <div className="form-group ">
                            <label htmlFor="inputRating" className="label-name">İlçe</label>
                            <input
                                className="form-control "

                                name="district" />
                        </div>

                        <div className="form-group ">
                            <label htmlFor="inputRating" className="label-name">Mahalle</label>
                            <input
                                className="form-control "

                                name="neighborhood" />
                        </div>

                        <div className="form-group ">
                            <label htmlFor="inputRating" className="label-name">Sokak</label>
                            <input
                                className="form-control "

                                name="street" />
                        </div>

                        <div className="form-group ">
                            <label htmlFor="inputRating" className="label-name">Bina No</label>
                            <input
                                className="form-control "

                                name="buildingNo" />
                        </div>

                        <div className="form-group ">
                            <label htmlFor="inputRating" className="label-name">İç Kapı No</label>
                            <input
                                className="form-control "

                                name="apartmentNo" />
                        </div>

                    </div>


                    <input type="submit" className="btn btn-danger btn-block" value="Kaydet" />

                </form>
                {this.state.toast &&
                    <ToastMessage type={this.state.type} message={this.state.message}></ToastMessage>
                }
            </div>

        );


    }

}
export default HomeAddPage;