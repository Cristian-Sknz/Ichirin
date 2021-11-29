import React from 'react';
import { Carousel } from 'react-responsive-carousel';

import {
  FeatureCarrousel as StyledFeatureCarrousel,
  CarrouselContainer,
  ImageContainer,
  CarrouselImage,
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
              <CarrouselImage
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
