import Slider from 'react-slick';
import style from './Home.module.css'

export default function FeatureCarrousel() {
  return (<div className={style.carrousel_container}>

  </div>);
}

/*

  var settings = {
    infinite: true,
    speed: 500,
    autoplay: true,
    slidesToShow: 2,
    slidesToScroll: 1,
    responsive: [
      {
        breakpoint: 768,
        settings: {
          infinite: true,
          autoplay: true,
          slidesToShow: 1,
          slidesToScroll: 1,
        }
      }
    ]
  };

  return (
    <div className={style.feature_carrousel}>
      <Slider {...settings} >
        <img src="./images/flower-background.jpg" width="200px"/>
        <img src="./images/flower-background.jpg" width="200px"/>
        <img src="./images/flower-background.jpg" width="200px"/>
      </Slider>
    </div>
  );
  */
