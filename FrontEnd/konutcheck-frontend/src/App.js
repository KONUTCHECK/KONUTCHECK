import './App.css';
import { Route, Routes } from 'react-router-dom';
import Menu from './components/menu/menu';
import HomePage from './components/homePage/homePage';
import ErrorPage from './components/error/errorPage';

function App() {
  return (
    <div className="App">
      <Menu></Menu>

      <Routes>
        <Route path='/' element={<HomePage></HomePage>}> </Route>
        <Route path='*' element={<ErrorPage></ErrorPage>}></Route>
      </Routes>
    </div>
  );
}

export default App;
