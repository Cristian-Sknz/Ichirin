import * as React from 'react';
import { Component } from 'react';
import { MangaData } from './MangaList';
import style from '../Home.module.css'
import RatingStars from '../../../models/RatingStar';


interface MangaListItemProps {
    data : MangaData;
}

class MangaListItem extends Component<MangaListItemProps> {
    render() { 
        let data = this.props.data;
        return (
            <li className={style.manga_list_item}>
              <div className={style.card_image}>
                <a href='# '>
                  <img src={data.image_url} alt='' />
                </a>
              </div>
              <div className={style.manga_info_card}>
                <h2>{data.name}</h2>
                <h3>{data.category.name}</h3>
              </div>
              <div className='manga_rating'>
                <RatingStars rating={data.rating} />
              </div>
            </li>
          );
    }
}
 
export default MangaListItem;