import React from 'react';
import NavigationBar from './InitialNavBar';
import '../css/welcome.css'
import { Link } from 'react-router-dom';

function Welcome() {
    return (

        <><NavigationBar />
                        <section class="home" id="home">
                            <div class="content"style={{marginLeft:20}}>
                                <h1>Order Your Food <span class="yellow">Easier & Faster.</span></h1>
                                <p>
                                    Foodo is a leading global online food delivery marketplace,
                                    connecting consumers and restaurants through its platform in different
                                    countries.
                                </p>
                                <Link to="/login"><button className='btn btn-warning btn-lg m-3 ms-9'>Lets Login</button></Link>
                            </div>
                            <div class="image">
                                <img src='https://res.cloudinary.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,h_1340/Lunch1-new_douhad' style={{maxWidth: 700 ,marginLeft:100,borderRadius: 150 / 2}} alt="" />
                            </div>
                        </section>
                    </>


                    );
  
}

                    export default Welcome;
