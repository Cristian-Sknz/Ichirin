import Image from 'next/image';

import { Carousel } from 'react-responsive-carousel';
import style from './Home.module.css';

function FeatureCarrousel() {
  const settings = {
    showThumbs: false,
    showIndicators: false,
    showStatus: false,
    showArrows: false,
    infiniteLoop: true,
    emulateTouch: true,
    autoPlay: true,
    interval: 5000,
  };

  let itens = [1, 2, 3];
  return (
    <section className={style.feature_carrousel}>
      <div className={style.carrousel_container}>
        <Carousel {...settings}>
          {itens.map((v) => {
            return (
              <div className={style.image_container} key={v}>
                  <Image
                    className={style.carrousel_image}
                    src='https://ichirinnohanayuriscan.com/wp-content/uploads/2021/10/banner-1.jpg'
                    layout={'fill'}
                    alt={'Feature Item'}
                  />
              </div>
            );
          })}
        </Carousel>
      </div>
    </section>
  );
}

export default FeatureCarrousel;