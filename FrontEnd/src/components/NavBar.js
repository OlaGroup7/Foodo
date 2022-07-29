import React, { useState } from "react";
import logo from '../images/logo3.jpg';
import 'bootstrap/dist/css/bootstrap.css';
import '../css/navbar.css'
import { Navbar, Nav } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import axios from "axios";
function NavigationBar() {
    const token1 = localStorage.getItem("token");
    //const USERDATA=JSON.parse(token1)
    //console.log('http://foodobackend.herokuapp.com/home-customer/'+token1.replace(/['"]+/g, ''));
    axios.get('https://foodobackend.herokuapp.com/home-customer/'+token1.replace(/['"]+/g, ''))
    .then(res=>{
        localStorage.setItem('uname',res.data.name)
    })
    const usera=localStorage.getItem("uname");
    return (
        <>
        <Navbar className="navbar fixed-top" bg="dark" variant="dark">
            <div className="navbar-brand">
                <img id="nav-logo" src={logo} alt="nav-logo" className="img-fluid d-inline-block align-baseline me-2" />
                <span className="nav-title">Foo</span><span className="nav-title-to">do</span>
            </div>
            <Nav className="me-auto">
                <Link to={"/homemain"} className="nav-link"><button type="button" className="btn btn-outline-light btn-lg text-white loginbtn me-2">Home</button></Link>
            </Nav>
            <div className="navbar-brand">
                <span className="nav-title">Hi{' '}</span><span className="nav-title-to">{usera}</span>
            </div>
            
            <Nav className="ms-auto">
                <Link to={"/profile"} className="nav-link"><button type="button" className="btn btn-outline-light btn-lg text-white loginbtn me-2">Profile</button></Link>
                <Link to={"/"} className="nav-link"><button type="button" className="btn btn-outline-light btn-lg text-white loginbtn me-2">Logout</button></Link>

            </Nav>
        </Navbar>
        </>
    );
}


export default NavigationBar;
