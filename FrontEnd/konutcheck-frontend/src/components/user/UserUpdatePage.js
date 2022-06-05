 import React, { useEffect, useState } from "react";
import Gender from "../general/combobox/RegisterCombobox/Gender";
import Education from "../general/combobox/RegisterCombobox/education";
import MaritialStatus from "../general/combobox/RegisterCombobox/marital_status";
import Usertype from "../general/combobox/RegisterCombobox/Usertype";
import axios from "axios";
import { Button } from "react-bootstrap";
import { Link } from "react-router-dom";
                                    
export default function UserUpdatePage() {

    const [name, setName] = useState('');
    const [surname, setSurname] = useState('');
    const [age, setAge] = useState('');
    const [userType, setUserType] = useState('');
    const [gender, setGender] = useState();
    const [education, setEducation] = useState('');
    const [job, setJob] = useState();
    const [maritialStatus, setMaritialStatus] = useState('');
    const [email, setEmail] = useState('');
    const [userPhoneNumber1, setUserPhoneNumber1] = useState();
    const [userPhoneNumber2, setUserPhoneNumber2] = useState();
    const [password, setPassword] = useState();
    const [id, setId] = useState(null);
    useEffect(() => {
        setId(localStorage.getItem('id'))
        setName(localStorage.getItem('İsim'));
        setSurname(localStorage.getItem('Soyisim'));
        setAge(localStorage.getItem('Yaş'));
        setUserType(localStorage.getItem('Kullanıcı Tipi'))
        setGender(localStorage.getItem('Cinsiyet'))
        setEducation(localStorage.getItem('Eğitim Durumu'));
        setMaritialStatus(localStorage.getItem('Evlilik Durumu'));
        setEmail(localStorage.getItem('Mail Adresi'))
        setUserPhoneNumber1(localStorage.getItem('Telefon Numarası 1 '))
        setUserPhoneNumber2(localStorage.getItem('Telefon Numarası 2 '));
        setPassword(localStorage.getItem('Şifre'));
    }, []);

    const updateAPIData = () => {
        axios.put('/user/update-user-infos', {
            id,
            name,
            surname,
            age,
            userType,
            gender,
            education,
            job,
            maritialStatus,
            email,
            userPhoneNumber1,
            userPhoneNumber2,
            password
        })
    }


    return (
        <div className="container col-md-6 offset-md-3">

            <form id="product-form" className="mt-5" >

                <div className="form-row">

                    <div className="form-group ">
                        <label htmlFor="inputRating">İsim</label>
                        <input
                            className="form-control "
                            value={name}
                            onChange={(e) => setName(e.target.value)} />
                    </div>

                    <div className="form-group ">
                        <label htmlFor="inputRating">Soyisim</label>
                        <input
                            className="form-control "
                            value={surname}
                            onChange={(e) => setSurname(e.target.value)} />
                    </div>
                    <div className="form-group ">
                        <label htmlFor="inputRating">Yaş</label>
                        <input
                            className="form-control "
                            value={age}
                            onChange={(e) => setAge(e.target.value)} />
                    </div>
                    <div className="form-group ">
                        <label htmlFor="inputRating">Kullanıcı Tipi</label>
                        <Usertype
                            fieldName="userType"
                            notNull={true}
                            value={userType}
                            onChange={(e) => setUserType(e.target.value)}
                        ></Usertype>
                    </div>
                   
                    <div className="form-group ">
                        <label htmlFor="inputRating">,Yaş</label>
                        <Gender
                            fieldName="gender"
                            notNull={true}
                            value={gender}
                            onChange={(e) => setGender(e.target.value)}
                        ></Gender>
                    </div>

                    <div className="form-group ">
                        <label htmlFor="inputRating">Eğitim Durumu</label>
                        <Education
                            fieldName="educationalStatus"
                            notNull={true}
                            value={education}
                            onChange={(e) => setEducation(e.target.value)}
                        ></Education>
                    </div>
                    
                    <div className="form-group ">
                        <label htmlFor="inputRating">İş</label>
                        <input
                            className="form-control "
                            value={job}
                            onChange={(e) => setJob(e.target.value)} />
                    </div>
                    <div className="form-group ">
                        <label htmlFor="inputRating">Evlilik Durumu</label>
                        <MaritialStatus
                            fieldName="maritialStatus"
                            notNull={true}
                            value={maritialStatus}
                            onChange={(e) => setMaritialStatus(e.target.value)}
                        ></MaritialStatus>
                    </div>
                    
                    <div className="form-group ">
                        <label htmlFor="inputRating">Mail Adresi</label>
                        <input
                            className="form-control "
                            value={email}
                            onChange={(e) => setEmail(e.target.value)} />
                    </div>
                    
                    <div className="form-group ">
                        <label htmlFor="inputRating">Telefon Numarası 1</label>
                        <input
                            className="form-control "
                            value={userPhoneNumber1}
                            onChange={(e) => setUserPhoneNumber1(e.target.value)} />
                    </div>

                    <div className="form-group ">
                        <label htmlFor="inputRating">Telefon Numarası 2</label>
                        <input
                            className="form-control "
                            value={userPhoneNumber2}
                            onChange={(e) => setUserPhoneNumber2(e.target.value)} />
                    </div>
                    
                    <div className="form-group ">
                        <label htmlFor="inputRating">Şifre</label>
                        <input
                            className="form-control "
                            value={password}
                            onChange={(e) => setPassword(e.target.value)} />
                    </div>
                  
                </div>
                <Link to='/users'>
                    <Button type='submit' onClick={() => updateAPIData()}>Güncelle</Button>
                </Link>
            </form>
        </div>
    );
}


