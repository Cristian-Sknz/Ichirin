import React from 'react';
import Image from 'next/image';
import classNames from 'classnames';

import MangaData from '../../../../lib/types';
import AnchorLink from '../../../models/AnchorLink';
import RatingStars from '../../../models/RatingStar';

import {
  MangaAgeRating,
  MangaCategory,
  MangaImageContainer,
  MangaItemInfo,
  MangaItemType,
  MangaListItem as MangaItem,
  MangaName,
  MangaRatingContainer,
} from '../style';

interface MangaListItemProps {
  data: MangaData;
}

const MangaListItem: React.FC<MangaListItemProps> = ({ data }) => {
  return (
    <MangaItem>
      <MangaImageContainer>
        <AnchorLink href={data.urlName}>
          <MangaAgeRating className={classNames({ isAdult: data.isAdult })}>
            18+
          </MangaAgeRating>
          <Image
            src={data.image_url}
            alt={data.name}
            width={160}
            height={230}
            loading='lazy'
          />
          <MangaItemType>{data.type.name}</MangaItemType>
        </AnchorLink>
      </MangaImageContainer>
      <MangaItemInfo>
        <MangaName>
          <AnchorLink href={data.urlName}>{data.name}</AnchorLink>
        </MangaName>
        
        <MangaCategory>
          <AnchorLink href={data.urlName}>{data.genre[0].name}</AnchorLink>
        </MangaCategory>
      </MangaItemInfo>

      <MangaRatingContainer>
        <RatingStars rating={data.rating} />
      </MangaRatingContainer>
    </MangaItem>
  );
};

export default MangaListItem;
