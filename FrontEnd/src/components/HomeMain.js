import React, { Component,useState } from 'react';
import 'bootstrap/dist/css/bootstrap.css';
//import Carousel from 'react-bootstrap/Carousel';
import Button from 'react-bootstrap/Button';
//import CardGroup from 'react-bootstrap/CardGroup';
import NavigationBar from './NavBar';
import Card from 'react-bootstrap/Card';
//import Caraousel from './caraousel';
import images from "./images";
import ImageSlider from "./ImageSlider";
import { Link } from 'react-router-dom';
import axios from 'axios';




export default function HomeMain() {
  /*const handleItalian()=>{
    axios.get("url").then(res()=>{
      localStorage.setItem('italian',res)
    })
  }*/
  
  const storecuisine1 =(e)=>{
    localStorage.setItem("cuisine",'NorthIndian')
  }
  const storecuisine2 =(e)=>{
    localStorage.setItem("cuisine",'SouthIndian')
  }
  const storecuisine3 =(e)=>{
    localStorage.setItem("cuisine",'Italian')
  }
  const storecuisine4 =(e)=>{
    localStorage.setItem("cuisine",'Mexican')
  }
  const storecuisine5 =(e)=>{
    localStorage.setItem("cuisine",'Continental')
  }
  const storecuisine6 =(e)=>{
    localStorage.setItem("cuisine",'Chinese')
  }
    return (
      <>
      <div style={{ paddingTop: "8%" }}>
      <NavigationBar />
      <ImageSlider images={images}/>
    <div style={{display: 'flex',margin:'70px', marginLeft:'200px'}}>
    <Card style={{ display:'flex',width: '15rem' ,margin:'30px', height: '15rem'}}>
      <Card.Img variant="top" src="https://b.zmtcdn.com/data/pictures/9/19570539/d7670e70e86ebafdc82b9461eebf854e.jpg?output-format=webp" width='20px' height='100px'/>
      <Card.Body>
        <Card.Title>South Indian</Card.Title>
        <br>
        </br>
        <Link to = '/southIndian'>
        <Button variant="primary" onClick={storecuisine2}>View Restraunts</Button>
        </Link>
        
      </Card.Body>
    </Card>
    
    <Card style={{direction:"flex",width: '15rem' ,margin:'30px', height: '15rem'}}>
      <Card.Img variant="top" src="https://b.zmtcdn.com/data/pictures/9/19570539/d7670e70e86ebafdc82b9461eebf854e.jpg?output-format=webp" width='20px' height='100px' />
      <Card.Body>
        <Card.Title>North Indian</Card.Title>
        <br>
        </br>
        <Link to = '/northIndian'>
        <Button variant="primary"onClick={storecuisine1}>View Restraunts</Button>
        </Link>
      </Card.Body>
    </Card>
    <Card style={{direction:"flex", width: '15rem' ,margin:'30px', height: '15rem'}}>
      <Card.Img variant="top" src='https://b.zmtcdn.com/data/pictures/9/19570539/d7670e70e86ebafdc82b9461eebf854e.jpg?output-format=webp' width='20px' height='100px' />
      <Card.Body>
        <Card.Title>Italian</Card.Title>
        <br>
        </br>
        <Link to = '/italian'>
        <Button variant="primary"onClick={storecuisine3}>View Restraunts</Button>
        </Link>
      </Card.Body>
    </Card>
    
    </div>
    <div style={{display: 'flex',margin:'70px',marginLeft:'200px'}}>
    <Card style={{ width: '15rem' ,margin:'30px', height: '15rem'}}>
      <Card.Img variant="top" src="https://b.zmtcdn.com/data/pictures/9/19570539/d7670e70e86ebafdc82b9461eebf854e.jpg?output-format=webp" width='20px' height='100px' />
      <Card.Body>
        <Card.Title>Mexican</Card.Title>
        <br>
        </br>
        <Link to = '/mexican'>
        <Button variant="primary"onClick={storecuisine4}>View Restraunts</Button>
        </Link>
      </Card.Body>
    </Card>
    <Card style={{ display:'flex',width: '15rem' ,margin:'30px', height: '15rem'}}>
      <Card.Img variant="top" src="https://b.zmtcdn.com/data/pictures/9/19570539/d7670e70e86ebafdc82b9461eebf854e.jpg?output-format=webp" width='20px' height='100px'/>
      <Card.Body>
        <Card.Title>Continental</Card.Title>
        <br>
        </br>
        <Link to = '/continental'>
        <Button variant="primary"onClick={storecuisine5}>View Restraunts</Button>
        </Link>
      </Card.Body>
    </Card>
    
    <Card style={{direction:"flex",width: '15rem' ,margin:'30px', height: '15rem'}}>
      <Card.Img variant="top" src="https://b.zmtcdn.com/data/pictures/9/19570539/d7670e70e86ebafdc82b9461eebf854e.jpg?output-format=webp" width='20px' height='100px' />
      <Card.Body>
        <Card.Title>Chinese</Card.Title>
        <br>
        </br>
        <Link to = '/chinese'>
        <Button variant="primary" onClick={storecuisine6}>View Restraunts</Button>
        </Link>
      </Card.Body>
    </Card>
    
    </div>
    </div>
    </>
    );
  }

