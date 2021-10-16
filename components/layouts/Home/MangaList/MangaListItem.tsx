import * as React from 'react';
import Image from 'next/image';

import RatingStars from '../../../models/RatingStar';
import MangaData from '../../../../lib/types';

import style from '../Home.module.css';
import ALink from '../../../models/ALink';

interface MangaListItemProps {
  data: MangaData;
}

export default function MangaListItem({ data }: MangaListItemProps) {
  return (
    <li className={style.manga_list_item}>
      <div className={style.card_image}>
        <ALink href={data.urlName}>
          {data.isAdult && <p className={style.manga_item_isAdult}>18+</p>}
          <Image
            src={data.image_url}
            alt={data.name}
            width={160}
            height={230}
            loading='lazy'
          />
          <p className={style.manga_item_type}>{data.type.name}</p>
        </ALink>
      </div>
      <div className={style.manga_info_card}>
        <h2 className={style.manga_name}>
          <ALink href={data.urlName}>{data.name}</ALink>
        </h2>
        <h3 className={style.manga_category}>
          <ALink href={data.urlName}>{data.genre[0].name}</ALink>
        </h3>
      </div>
      <div className='manga_rating'>
        <RatingStars rating={data.rating} />
      </div>
    </li>
  );
}
