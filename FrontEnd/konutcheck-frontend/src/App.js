import './App.css';
import { Route, Routes } from 'react-router-dom';
import Menu from './components/menu/menu';
import HomePage from './components/homePage/homePage';
import ErrorPage from './components/error/errorPage';
import LoginPage from './components/authentication/loginPage';
import React from 'react';
import HomeListPage from './components/home/HomeListPage';
import HomeAddPage from './components/home/HomeAddPage';

import Register from './components/authentication/register';

import DetailHomeInfoPage from './components/home/DetailHomeInfoPage';
import HomeUpdatePage from './components/home/HomeUpdatePage';
import HomeFilterPage from './components/home/HomeFilterPage';

class App extends React.Component {

  constructor(props){
    super(props)

    this.state = {
      isLoggedOn : false
    }

    this.login = this.login.bind(this);
    this.logout = this.logout.bind(this);
  }

  getIsLogged(){
    const token = sessionStorage.getItem('token')
    const isLogged = token ? true : false
    return isLogged
  }

  login(){
    this.setState({isLoggedOn : true})
  }

  logout(){
    this.setState({isLoggedOn : false})
    sessionStorage.clear()
  }

  render(){

    const isLogged = this.getIsLogged();

    return (
    <div className="App">
      <Menu isLoggedOn={isLogged} logout={this.logout}></Menu>
      <Routes>
        <Route path='/' element={<HomePage></HomePage>}> </Route>
        <Route path='*' element={<ErrorPage></ErrorPage>}></Route>
        <Route path="/login" element={<LoginPage login={this.login}></LoginPage>}></Route>
        <Route path="/homes" element={<HomeListPage></HomeListPage>}></Route>
        <Route path="/add-homes" element={<HomeAddPage></HomeAddPage>}></Route>

        <Route path="/register" element={<Register></Register>}></Route>


        <Route path = "/view-home/:id" element = {<DetailHomeInfoPage></DetailHomeInfoPage>}></Route>
        <Route path="/update-home-infos" element={<HomeUpdatePage></HomeUpdatePage>}></Route>
        <Route path="/get-homes-by" element={<HomeFilterPage></HomeFilterPage>}></Route>
      
      </Routes> 
    </div>
  );
  }
  
}

export default App;
