import Slider from "react-slick";
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";
import '../css/style.css'
import React from 'react'
import axios from "axios";
const ImageSlider = ({images}) => {
  
  const settings = {
    infinite: true,
    dots: true,
    slidesToShow: 1,
    slidesToScroll: 1,
    lazyLoad: true,
    autoplay: true,
  autoplaySpeed: 2000,
   
  };
  return (
    <>
    <div className="bgk">
    <div>
    <div style={{ marginLeft: '2rem' }} ><h3>What would you like to eat ?</h3></div>
    </div>
      <div className="imgslider">
        <Slider {...settings}>
          {images.map((item) => (
            <div key={item.id}>
              <img src={item.src}  alt={item.alt} style={{borderRadius: 20}}/>
            </div>
          ))}
        </Slider>
      </div>
      </div>
          </>
  )
}
export default ImageSlider;