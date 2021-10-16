import * as React from 'react';
import Link from 'next/link';
import Image from 'next/image';

import RatingStars from '../../../models/RatingStar';
import MangaData from '../../../../lib/types';

import style from '../Home.module.css';

interface MangaListItemProps {
  data: MangaData;
}

export default function MangaListItem({ data }: MangaListItemProps) {
  return (
    <li className={style.manga_list_item}>
      <div className={style.card_image}>
        <Link href={data.urlName}>
          <a>
            <Image
              src={data.image_url}
              alt={data.name}
              width={160}
              height={230}
              loading='lazy'
            />
          </a>
        </Link>
      </div>
      <div className={style.manga_info_card}>
        <h2 className={style.manga_name}>
          <Link href={data.urlName}>
            <a>{data.name}</a>
          </Link>
        </h2>
        <h3 className={style.manga_category}>
          <Link href={data.urlName}>
            <a>{data.genre[0].name}</a>
          </Link>
        </h3>
      </div>
      <div className='manga_rating'>
        <RatingStars rating={data.rating} />
      </div>
    </li>
  );
}
