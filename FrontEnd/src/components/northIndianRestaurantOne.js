import React, { Component } from 'react';
import { useState } from 'react';
import { useEffect } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.css';
//import Carousel from 'react-bootstrap/Carousel';
import Button from 'react-bootstrap/Button';
//import CardGroup from 'react-bootstrap/CardGroup';
import NavigationBar from './NavBar';
import Card from 'react-bootstrap/Card';
//import Caraousel from './caraousel';
import images from "./images";
import ImageSlider from "./ImageSlider";
import Restaurants from "./northIndianRestaurants.json";
import Items from "./northIndianRestauantOneItems.json"
import CartButton from './cartbutton';

function NorthIndianRestaurantOne() {
    return (
        <>
            <NavigationBar />
            <div style={{ paddingTop: "8%" }}>
                <div className='northIndian' style={{ display: 'flex', margin: '30px' }}>
                    <div className='posts' style={{ display: 'flex', margin: '25px' }}>
                        {Items.map(post => {
                            return (
                                <>
                                    <Card style={{ display: "flex", width: '15rem', margin: '30px', height: '20rem' }}>
                                        <Card.Img variant="top" src="https://b.zmtcdn.com/data/pictures/9/19570539/d7670e70e86ebafdc82b9461eebf854e.jpg?output-format=webp" width='20px' height='100px' />
                                        <Card.Body>
                                            <h4>{post.r_name} </h4>
                                            <p>{post.r_description}</p>
                                            <Button variant="primary">₹{post.r_id}</Button>
                                            <CartButton />
                                        </Card.Body>
                                    </Card>
                                </>
                            )
                        })}
                        
                    </div>
                    
                </div>
                
            </div>
            <div style={{marginLeft:'1100px'}}>
                <Link to="/checkout">
            <button type="button" class="btn btn-danger ms-5 mb-5">Place Order</button>
            </Link>
            </div>
            
        </>
    )
}

export default NorthIndianRestaurantOne;