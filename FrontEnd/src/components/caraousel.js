//import Carousel from '@brainhubeu/react-carousel';
//import Icon from 'react-fa';
//import '@brainhubeu/react-carousel/lib/style.css';
import 'bootstrap/dist/css/bootstrap.css';
import Carousel from 'react-bootstrap/Carousel';
import React, { Component } from 'react';

export default class Caraousel extends Component {
render() {
  return (
    <Carousel variant="dark">
      <Carousel.Item>
        <img
          className="d-block w-100"
          src="https://b.zmtcdn.com/data/dish_photos/d01/b428c38fa7bdc4bc2a40595000377d01.jpg?fit=around|130:130&crop=130:130;*,*"
          alt="First slide"
          height='auto'
          width="100%%"
        />
        <Carousel.Caption>
          <h5>First slide label</h5>
          <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
        </Carousel.Caption>
      </Carousel.Item>
      <Carousel.Item>
        <img
          className="d-block w-100"
          src="holder.js/800x400?text=Second slide&bg=eee"
          alt="Second slide"
        />
        <Carousel.Caption>
          <h5>Second slide label</h5>
          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
        </Carousel.Caption>
      </Carousel.Item>
      <Carousel.Item>
        <img
          className="d-block w-100"
          src="holder.js/800x400?text=Third slide&bg=e5e5e5"
          alt="Third slide"
        />
        <Carousel.Caption>
          <h5>Third slide label</h5>
          <p>
            Praesent commodo cursus magna, vel scelerisque nisl consectetur.
          </p>
        </Carousel.Caption>
      </Carousel.Item>
    </Carousel>
  );
}
}