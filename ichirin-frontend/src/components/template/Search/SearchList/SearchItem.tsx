import React from 'react';
import Image from 'next/image';

import MangaData from '@ichirin/lib/types';
import { textLimiter } from '@ichirin/lib/Util';
import AnchorLink from '@models/AnchorLink';
import RatingStars from '@models/RatingStar';
import {
  SearchItemDescription,
  SearchItemImage,
  SearchItemInfo,
  SearchItem as StyledSearchItem,
} from '../style';

type SearchItemProps = {
  item: MangaData;
};

const SearchItem: React.FC<SearchItemProps> = ({ item }) => {
  return (
    <StyledSearchItem>
      <AnchorLink href={item.urlName}>
        <SearchItemImage>
          <Image
            src={item.image_url}
            loading={'lazy'}
            layout={'fill'}
            alt={item.name}
          />
        </SearchItemImage>
        <SearchItemInfo>
          <h3 className='item_title'>{item.name}</h3>
          <p className='item_genre'>{item.genre[0].name}</p>
          <p className='item_date'>{item.releaseYear}</p>
          <RatingStars rating={item.rating} />
        </SearchItemInfo>

        <SearchItemDescription>
          <p>{textLimiter(item.description.join(';'), 200)}</p>
        </SearchItemDescription>
      </AnchorLink>
    </StyledSearchItem>
  );
};

export default SearchItem;
