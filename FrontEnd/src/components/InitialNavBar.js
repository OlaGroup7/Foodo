import React from "react";
import logo from '../images/logo3.jpg';
import 'bootstrap/dist/css/bootstrap.css';
import '../css/navbar.css'
import {Navbar,Nav} from 'react-bootstrap';
import {Link} from 'react-router-dom';

function NavigationBar(){
        return(
        <Navbar className="navbar fixed-top" bg="dark" variant="dark">
            <Link to={"/"} className="navbar-brand">
            <img id="nav-logo" src={logo} alt="nav-logo" className="img-fluid d-inline-block align-baseline me-2" />
            <span className="nav-title">Foo</span><span className="nav-title-to">do</span>
            </Link>
          {/*<Nav className="me-auto">
            <Link to={"home"} className="nav-link"><button type="button" className="btn btn-outline-light btn-lg text-white loginbtn me-2">Home</button></Link>
            <Link to={"profile"} className="nav-link"><button type="button" className="btn btn-outline-light btn-lg text-white loginbtn me-2">Profile</button></Link>nk>
        </Nav>*/}
            <Nav className="ms-auto">
                <Link to={"/login"} className="nav-link"><button type="button" className="btn btn-outline-light btn-lg text-white loginbtn me-2">Login</button></Link>
                <Link to={"/register"} className="nav-link"><button type="button" className="btn btn-outline-light btn-lg text-white loginbtn me-2">Register</button></Link>
            </Nav>
      </Navbar>
        );
    }


export default NavigationBar;
