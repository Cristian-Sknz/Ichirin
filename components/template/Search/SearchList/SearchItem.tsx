import Image from 'next/image'
import { lazy } from 'react';
import MangaData from '../../../../lib/types';
import { textLimiter } from '../../../../lib/Util';
import AnchorLink from '../../../models/ALink';
import RatingStars from '../../../models/RatingStar';
import style from '../Search.module.css';

type SearchItemProps = {
    item: MangaData;
}

export default function SearchItem({item} : SearchItemProps) {
    return (
        <li className={style.search_item}>
            <AnchorLink href={item.urlName}>
                <div className={style.search_item_image}>
                    <Image 
                        src={item.image_url}
                        loading={'lazy'}
                        layout={'fill'}
                    />
                </div>
                <div className={style.search_item_info}>
                    <h3 className='item_title'>{item.name}</h3>
                    <p className='item_genre'>{item.genre[0].name}</p>
                    <p className='item_date'>{item.releaseYear}</p>
                    <RatingStars rating={item.rating}/>
                </div>
                
                <div className={style.search_item_desc}>
                    <p>{textLimiter(item.description.join(';'), 200)}</p>
                </div>
            </AnchorLink>
        </li>
    )
}