import './App.css';
import { Route, Routes } from 'react-router-dom';
import Menu from './components/menu/menu';
import HomePage from './components/homePage/homePage';
import ErrorPage from './components/error/errorPage';
import LoginPage from './components/authentication/loginPage';
import React from 'react';

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
      </Routes>
    </div>
  );
  }
  
}

export default App;
