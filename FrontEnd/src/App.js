import React, { useState } from 'react';
import './App.css';
import Welcome from './components/Welcome';
import Profile from './components/Profile';
import Login from "./components/user/login";
import {BrowserRouter,Route,Routes} from 'react-router-dom';
import Register from './components/user/Register';
import HomeMain from './components/HomeMain';
import  NorthIndian from './components/northIndian';
import  SouthIndian from './components/southIndian';
import  Mexican from './components/mexican';
import  Italian from './components/italian';
import  Continental from './components/continental';
import  Chinese from './components/chinese';
import  NorthIndianRestaurantOne  from './components/northIndianRestaurantOne';
import CheckOut from './components/checkout';
export const itemContext = React.createContext();

function App() {
  return (
    <>
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Welcome></Welcome>}></Route>
        <Route path="/homemain" element={<HomeMain />}></Route>
        <Route path="/profile" element={<Profile></Profile>}></Route>
        <Route path="/login" element={<Login></Login>} />
        <Route path="/register" element={<Register/>} />
        <Route path="/northIndian" element={<NorthIndian />} />
        <Route path="/southIndian" element={<SouthIndian />} />
        <Route path="/mexican" element={<Mexican />} />
        <Route path="/italian" element={<Italian />} />
        <Route path="/continental" element={<Continental />} />
        <Route path="/chinese" element={<Chinese />} />
        <Route path="/northIndianRestaurantOne" element={< NorthIndianRestaurantOne />} />
        <Route path="/checkout" element={<CheckOut />} />
      </Routes>
    </BrowserRouter>
    </>
  );
}

export default App;
