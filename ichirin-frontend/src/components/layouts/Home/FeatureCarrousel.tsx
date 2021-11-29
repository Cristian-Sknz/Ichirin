import Image from 'next/image';

import { Carousel } from 'react-responsive-carousel';
import style from './Home.module.css';
import {
  FeatureCarrousel as StyledFeatureCarrousel,
  CarrouselContainer,
  ImageContainer,
} from './style';

const FeatureCarrousel: React.FC = () => {
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
    <StyledFeatureCarrousel>
      <CarrouselContainer>
        <Carousel {...settings}>
          {itens.map((v) => (
            <ImageContainer key={v}>
              <Image
                className={style.carrousel_image}
                src='https://ichirinnohanayuriscan.com/wp-content/uploads/2021/10/banner-1.jpg'
                layout={'fill'}
                alt={'Feature Item'}
              />
            </ImageContainer>
          ))}
        </Carousel>
      </CarrouselContainer>
    </StyledFeatureCarrousel>
  );
};

export default FeatureCarrousel;
