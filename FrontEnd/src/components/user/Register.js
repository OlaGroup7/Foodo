import React, { useState, useEffect } from 'react'
import axios from 'axios';
import { Link } from 'react-router-dom';
import { useNavigate } from 'react-router-dom'
import NavigationBar from '../InitialNavBar';
import Signimg from './Sign_img'
function Register() {
    const [user, setUser] = useState({ name: "", email: "", password: "", phone: "", address: "", role: "" })
    const [msg, setMsg] = useState('');
    const history = useNavigate();
    useEffect(() => {
        //console.log("register rendered");
        if (msg.includes("Success")) {

        }
    }, [msg, history])

    const changeMe = (e) => {
        const { name, value } = e.target;
        setUser({
            ...user, [name]: value
        })
    }
    const success = { padding: "10px 15px", border: "1px solid green", color: "green" }
    const fail = { padding: "10px 15px", border: "1px solid red", color: "red" }
    const registerMe = (e) => {

        e.preventDefault();
        //api post to server
        axios.post('https://foodobackend.herokuapp.com/signup', user)
            .then(res => {
                //console.log(res.data.flag)
                if(res.data.flag==false){

                    alert("User ALready Exist Kindly Login")
                }
                else{
                setMsg("Registered Successfully");
                alert("user registered")
                //console.log(res.data);
                history("/login")
            }
                //redirect to login page
            })
            .catch((e) => {
                setMsg("Something went wrong. Please try again later");
            })
    }
    return (
        <>
            <NavigationBar />
            <div className="container" style={{paddingTop:"6%"}}>
                <section className='d-flex justify-content-between'>
                    <div className="left_data mt-3 p-3" style={{ width: "100%" }}>
                        <form className="form1" onSubmit={registerMe}>
                            <h2>Register Form</h2><br />
                            <div className="mb-3 col-lg-6">
                            <div className="d-flex flex-column g-2">
                                <div className="form-group">
                                    <div className="form-group">
                                        <label htmlFor="name" className="form-label m-2 h5">Name</label>
                                        <input type="name" name="name" placeholder="Name" className="form-control-lg" value={user.name} onChange={changeMe} required /></div>
                                    <div className="form-group">
                                        <label htmlFor="email" className="form-label m-2 h5">Email</label>
                                        <input type="email" name="email" placeholder="Email" className="form-control-lg" value={user.email} onChange={changeMe} required /></div>
                                    <div className="form-group">
                                        <label htmlFor="password" className="form-label m-2 h5">Password</label>
                                        <input type="password" name="password" placeholder="Password" className="form-control-lg" value={user.password} onChange={changeMe} required /></div>
                                    <div className="form-group">
                                        <label htmlFor="phone" className="form-label m-2 h5">Phone</label>
                                        <input type="number" name="phone" placeholder="Phone" className="form-control-lg" value={user.phone} onChange={changeMe} required /></div>
                                    <div className="form-group">
                                    <label htmlFor="address" className="form-label m-2 h5">Address</label>
                                    <textarea type="text" name="address" placeholder="Address" className="form-control-lg" value={user.address} onChange={changeMe} required /></div></div>
                                <div className="form-group">
                                    <label htmlFor="role" className="form-label m-2 h5">Role</label>
                                    <input type="text" name="role" placeholder="Role" className="form-control-lg" value={user.role} onChange={changeMe} required /></div>
                                    </div>
                                <button className="btn btn-primary my-3 h4">Sign Up</button>
                                <div className="h5 text-center" style={msg === '' ? {} : (msg.includes("Success") ? success : fail)}>{msg}</div>
                                </div>
                                <hr />
                                <h3><span>Already have an account?  |  <Link to="/login">Sign in</Link></span> </h3>
                            

                        </form>
                    </div>
                    <div className="left_data mt-5 p-6" style={{ width: "50%" }}>
                        <Signimg/>
                    </div>
                </section>
            </div>
        </>
    )
}

export default React.memo(Register)