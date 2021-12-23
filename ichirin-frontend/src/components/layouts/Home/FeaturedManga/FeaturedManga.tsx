import React from 'react';
import Image from 'next/image';
import { FontAwesomeIcon as Icon } from '@fortawesome/react-fontawesome';

import MangaData from '@ichirin/lib/types';
import { textLimiter } from '@ichirin/lib/Util';

import AnchorLink from '@models/AnchorLink';
import RatingStars from '@models/RatingStar';
import {
  FeaturedItem,
  FeaturedItemTitle,
  MangaCategory,
  MangaDescription,
  MangaImageContainer,
  MangaItemInfo,
  MangaName,
  MangaRatingContainer,
  Readmore,
} from '../style';

type FeaturedMangaProps = {
  data: MangaData;
};

const FeaturedManga: React.FC<FeaturedMangaProps> = ({ data }) => {
  return (
    <FeaturedItem>
      <MangaImageContainer>
        <AnchorLink href={data.urlName}>
          <Image
            src={data.image_url}
            alt={data.name}
            width={193}
            height={278}
            loading='eager'
          />
        </AnchorLink>
      </MangaImageContainer>

      <MangaItemInfo>
        <FeaturedItemTitle>
          <MangaName>
            <AnchorLink href={data.urlName}>{data.name}</AnchorLink>
          </MangaName>
          <MangaCategory>
            <a href='# '>{data.genre[0]?.name}</a>
          </MangaCategory>
        </FeaturedItemTitle>
        <MangaRatingContainer>
          <RatingStars rating={data.rating} />
        </MangaRatingContainer>
      </MangaItemInfo>

      <MangaDescription>
        {textLimiter(data.description.join(';'), 308)}
      </MangaDescription>

      <Readmore href={data.urlName}>
        Continuar Lendo <Icon icon={['fas', 'arrow-right']} />
      </Readmore>
    </FeaturedItem>
  );
};

export default FeaturedManga;
