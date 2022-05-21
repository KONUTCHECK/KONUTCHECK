import React, { useEffect, useState } from "react";
import Countries from "../general/combobox/HomeCombobox/Countries";
import Cities from "../general/combobox/HomeCombobox/Cities";
import HomeAspects from "../general/combobox/HomeCombobox/HomeAspects";
import HomeTypes from "../general/combobox/HomeCombobox/HomeTypes";
import WarningSystemType from "../general/combobox/HomeCombobox/WarningSystemType";
import axios from "axios";
import { Button } from "react-bootstrap";
import { Link } from "react-router-dom";

export default function HomeUpdatePage() {

    /*const [amount, setAmount] = useState('');
    const [deposit, setDeposit] = useState('');
    const [dues, setDues] = useState('');
    const [numberOfRooms, setNumberOfRooms] = useState('');
    const [warningSystem, setWarningSystem] = useState();
    const [buildingAge, setBuildingAge] = useState('');
    const [homeAspect, setHomeAspect] = useState();
    const [floor, setFloor] = useState('');
    const [homeSize, setHomeSize] = useState('');
    const [homeType, setHomeType] = useState();
    const [country, setCountry] = useState();
    const [city, setCity] = useState();
    const [district, setDistrict] = useState('');
    const [neighborhood, setNeighborhood] = useState('');
    const [street, setStreet] = useState('');
    const [buildingNo, setBuildingNo] = useState('');
    const [apartmentNo, setApartmentNo] = useState('');
    const [announcementDate, setAnnouncementDate] = useState('');
    const [id, setId] = useState(null);

    useEffect(() => {
        setId(localStorage.getItem('id'))
        setAmount(localStorage.getItem('Fiyat'));
        setDeposit(localStorage.getItem('Depozit'));
        setDues(localStorage.getItem('Aidat'))
        setNumberOfRooms(localStorage.getItem('Oda Sayısı'))
        setWarningSystem(localStorage.getItem('Isınma Şekli'));
        setBuildingAge(localStorage.getItem('Bina Yaşı'));
        setHomeAspect(localStorage.getItem('Cephe'))
        setFloor(localStorage.getItem('Bulunduğu Kat'))
        setHomeSize(localStorage.getItem('Metrekare'));
        setHomeType(localStorage.getItem('Ev Tipi'));
        setCountry(localStorage.getItem('Ülke'))
        setCity(localStorage.getItem('Şehir'))
        setDistrict(localStorage.getItem('İlçe'));
        setNeighborhood(localStorage.getItem('Mahalle'));
        setStreet(localStorage.getItem('Sokak'));
        setBuildingNo(localStorage.getItem('Bina No'));
        setApartmentNo(localStorage.getItem('Kapı No'));
        setAnnouncementDate(localStorage.getItem('Son Güncelleme'));
    }, []);


    const updateAPIData = () => {
        axios.put('/homes/update-home-infos', {
            id,
            amount, 
            deposit, 
            dues, 
            numberOfRooms, 
            warningSystem, 
            buildingAge, 
            homeAspect, 
            floor, 
            homeSize, 
            homeType, 
            country, 
            city, 
            district, 
            neighborhood,  
            street, 
            buildingNo, 
            apartmentNo, 
            announcementDate
        })
    }

    return (
        <div className="container col-md-6 offset-md-3">

            <form id="product-form" className="mt-5" >

                <div className="form-row">

                    <div className="form-group ">
                        <label htmlFor="inputRating">Fiyat</label>
                        <input
                            className="form-control "
                            value={amount}
                            onChange={(e) => setAmount(e.target.value)} />
                    </div>

                    <div className="form-group ">
                        <label htmlFor="inputRating">Depozit</label>
                        <input
                            className="form-control "
                            value={deposit}
                            onChange={(e) => setDeposit(e.target.value)} />
                    </div>

                    <div className="form-group ">
                        <label htmlFor="inputRating">Aidat</label>
                        <input
                            className="form-control "
                            value={dues}
                            onChange={(e) => setDues(e.target.value)} />
                    </div>

                    <div className="form-group ">
                        <label htmlFor="inputRating">Oda Sayısı</label>
                        <input
                            className="form-control "
                            value={numberOfRooms}
                            onChange={(e) => setNumberOfRooms(e.target.value)} />
                    </div>

                    <div className="form-group ">
                        <label htmlFor="inputRating">Isınma Şekli</label>
                        <WarningSystemType
                            fieldName="warningSystem"
                            notNull={true}
                            value={warningSystem}
                            onChange={(e) => setWarningSystem(e.target.value)}
                        ></WarningSystemType>
                    </div>

                    <div className="form-group ">
                        <label htmlFor="inputRating">Bina Yaşı</label>
                        <input
                            className="form-control "
                            value={buildingAge}
                            onChange={(e) => setBuildingAge(e.target.value)} />
                    </div>

                    <div className="form-group ">
                        <label htmlFor="inputRating">Cephe</label>
                        <HomeAspects
                            fieldName="warningSystem"
                            notNull={true}
                            value={homeAspect}
                            onChange={(e) => setHomeAspect(e.target.value)}
                        ></HomeAspects>
                    </div>

                    <div className="form-group ">
                        <label htmlFor="inputRating">Bulunduğu Kat</label>
                        <input
                            className="form-control "
                            value={floor}
                            onChange={(e) => setFloor(e.target.value)} />
                    </div>

                    <div className="form-group ">
                        <label htmlFor="inputRating">Metrekare</label>
                        <input
                            className="form-control "
                            value={homeSize}
                            onChange={(e) => setHomeSize(e.target.value)} />
                    </div>

                    <div className="form-group ">
                        <label htmlFor="inputRating">Ev Tipi</label>
                        <HomeTypes
                            fieldName="warningSystem"
                            notNull={true}
                            value={homeType}
                            onChange={(e) => setHomeType(e.target.value)}
                        ></HomeTypes>
                    </div>

                    <div className="form-group ">
                        <label htmlFor="inputRating">Ülke</label>
                        <Countries
                            fieldName="warningSystem"
                            notNull={true}
                            value={country}
                            onChange={(e) => setCountry(e.target.value)}
                        ></Countries>
                    </div>

                    <div className="form-group ">
                        <label htmlFor="inputRating">Şehir</label>
                        <Cities
                            fieldName="warningSystem"
                            notNull={true}
                            value={city}
                            onChange={(e) => setCity(e.target.value)}
                        ></Cities>
                    </div>

                    <div className="form-group ">
                        <label htmlFor="inputRating">İlçe</label>
                        <input
                            className="form-control "
                            value={district}
                            onChange={(e) => setDistrict(e.target.value)} />
                    </div>

                    <div className="form-group ">
                        <label htmlFor="inputRating">Mahalle</label>
                        <input
                            className="form-control "
                            value={neighborhood}
                            onChange={(e) => setNeighborhood(e.target.value)} />
                    </div>

                    <div className="form-group ">
                        <label htmlFor="inputRating">Sokak</label>
                        <input
                            className="form-control "
                            value={street}
                            onChange={(e) => setStreet(e.target.value)} />
                    </div>

                    <div className="form-group ">
                        <label htmlFor="inputRating">Bina No</label>
                        <input
                            className="form-control "
                            value={buildingNo}
                            onChange={(e) => setBuildingNo(e.target.value)} />
                    </div>

                    <div className="form-group ">
                        <label htmlFor="inputRating">İç Kapı No</label>
                        <input
                            className="form-control "
                            value={apartmentNo}
                            onChange={(e) => setApartmentNo(e.target.value)} />
                    </div>

                    <div className="form-group ">
                        <label htmlFor="inputRating">Son Güncelleme</label>
                        <input
                            className="form-control "
                            value={announcementDate}
                            onChange={(e) => setAnnouncementDate(e.target.value)} />
                    </div>
                </div>
                <Link to='#'>
                <Button type='submit' onClick={updateAPIData()}>Update</Button>
                </Link>
            </form>
        </div>
    );*/
}

