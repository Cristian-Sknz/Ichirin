import * as React from 'react';
import { Component } from 'react';
import Link from 'next/link';

import RatingStars from '../../../models/RatingStar';
import MangaData from '../../../../lib/types';

import style from '../Home.module.css';

interface MangaListItemProps {
  data: MangaData;
}

class MangaListItem extends Component<MangaListItemProps> {
  render() {
    let data = this.props.data;
    return (
      <li className={style.manga_list_item}>
        <div className={style.card_image}>
          <Link href={data.url}>
            <a>
              <img src={data.image_url} alt='' />
            </a>
          </Link>
        </div>
        <div className={style.manga_info_card}>
          <h2 className={style.manga_name}>
            <Link href={data.url}>
              <a>{data.name}</a>
            </Link>
          </h2>
          <h3 className={style.manga_category}>
            <a href={data.url}>{data.genre[0].name}</a>
          </h3>
        </div>
        <div className='manga_rating'>
          <RatingStars rating={data.rating} />
        </div>
      </li>
    );
  }
}

export default MangaListItem;
