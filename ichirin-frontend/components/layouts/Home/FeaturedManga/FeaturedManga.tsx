import Image from 'next/image';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import MangaData from '../../../../lib/types';
import RatingStars from '../../../models/RatingStar';

import { textLimiter } from '../../../../lib/Util';
import style from '../Home.module.css';
import AnchorLink from '../../../models/AnchorLink';

type FeaturedMangaProps = {
  data: MangaData;
};

export default function FeaturedManga({ data }: FeaturedMangaProps) {
  return (
    <div className={style.featured_item_container}>
      <div className={style.manga_image}>
        <AnchorLink href={data.urlName}>
            <Image
              src={data.image_url}
              alt={data.name}
              width={193}
              height={278}
              loading='eager'
            />
        </AnchorLink>
      </div>

      <div className={style.manga_info}>
        <div className={style.manga_title}>
          <h2 className={style.manga_name}>
            <AnchorLink href={data.urlName}>
              {data.name}
            </AnchorLink>
          </h2>
          <h3 className={style.manga_category}>
            <a href='# '>{data.genre[0]?.name}</a>
          </h3>
        </div>
        <div className='manga_rating'>
          <RatingStars rating={data.rating} />
        </div>
      </div>

      <div className={style.manga_description}>
        {textLimiter(data.description.join(';'), 308)}
      </div>
AnchorLink
      <AnchorLink href={data.urlName} className={style.readmore}>
          Continuar Lendo <FontAwesomeIcon icon={['fas', 'arrow-right']} />
      </AnchorLink>
    </div>
  );
}
