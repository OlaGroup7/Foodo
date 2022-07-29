import React, { useState } from 'react'
import axios from 'axios';
import { Link, useNavigate } from 'react-router-dom';
import NavigationBar from '../InitialNavBar';
import Signimg from './Sign_img'

function Login() {
    const Navigate = useNavigate();
    const [userLogin, setUserLogin] = useState({ email: "", password: "" });



    const checkCred = (e) => {
        e.preventDefault();
        //api call to fetch users
        axios.post("https://foodobackend.herokuapp.com/login", userLogin)
            .then(response => {
                if(response.data.flag===false){
                    alert("Enter valid Details")
                }
                else{
                localStorage.setItem("token", response.data._id)
                alert("User Successfully Logged In")
                Navigate("/homemain")}
            })
            .catch((e) => {
                alert("Please enter valid credentials")
            })

    }
    const loginMe = (e) => {
        const { name, value } = e.target;
        setUserLogin({
            ...userLogin, [name]: value
        })
    }
    return (

        <>
            <NavigationBar />
            <div className="container" style={{paddingTop:"6%"}}>
                <section className='d-flex justify-content-between'>
                    <div className="left_data mt-3 p-3" style={{ width: "100%" }}>
                        <form className="form1" onSubmit={checkCred}>
                            <h2>Login</h2><br />
                            <div className="mb-3 col-lg-6">
                                <div className="form-group d-flex flex-column g-2">

                                    <label htmlFor="email" className="form-label m-2 h5">Email</label>
                                    <input type="email" name="email" className="form-control-lg" value={userLogin.email} onChange={loginMe} placeholder="Email" required /></div>
                                <div className="form-group d-flex flex-column g-2">
                                    <label htmlFor="password" className="form-label m-2 h5">Password</label>
                                    <input type="password" name="password" className="form-control-lg" value={userLogin.password} onChange={loginMe} placeholder="Password" required />
                                </div>
                            </div>
                            <button className="btn btn-primary btn-lg m-3 ms-0">Sign in</button>
                            {/* {msg  && <span style={{color:'red',padding:'5px'}}>{msg}</span> } */}
                            <hr />
                            <br></br>
                            <br></br>
                            <h3><span>Don't have an account?  |   <Link to="/register">Register Here</Link></span> </h3>
                        </form>
                    </div>
                    <div className="left_data mt-5 p-6" style={{ width: "50%" }}>
                        <Signimg />
                    </div>
                </section>
            </div>
        </>
    )
}
export default (Login)