import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import RatingStars from '../../../models/RatingStar';
import style from '../Home.module.css';
import { MangaData } from '../MangaList/MangaList';

type FeaturedMangaProps = {
  data : MangaData;
}

export default function FeaturedManga({data} : FeaturedMangaProps) {
  return (
    <div className={style.featured_item_container}>
      <div className={style.manga_image}>
        <img src={data.image_url} alt='manga image' />
      </div>
      <div className={style.manga_info}>
        <div className={style.manga_title}>
          <h2>{data.name}</h2>
          <h3>{data.category.name}</h3>
        </div>
        <div className='manga_rating'>
          <RatingStars rating={data.rating} />
        </div>
      </div>

      <div className={style.manga_description}>
        {data.description}
      </div>

      <a className={style.readmore} href='# '>
        Continuar Lendo <FontAwesomeIcon icon={['fas', 'arrow-right']}/>
      </a>
    </div>
  );
}
