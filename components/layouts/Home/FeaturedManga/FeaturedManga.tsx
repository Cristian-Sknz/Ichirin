import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import RatingStars from '../../../models/RatingStar';
import style from '../Home.module.css';
import { MangaData } from '../MangaList/MangaList';

type FeaturedMangaProps = {
  data: MangaData;
};

export default function FeaturedManga({ data }: FeaturedMangaProps) {

  function textLimiter(text: string, size: number) {
    if (text.length > size){
      return `${text.substring(0, size)}...`;
    }
    return text;
  }

  return (
    <div className={style.featured_item_container}>
      <div className={style.manga_image}>
        <a href={data.url}>
          <img src={data.image_url} alt='manga image' />
        </a>
      </div>
      
      <div className={style.manga_info}>
        <div className={style.manga_title}>
          <h2 className={style.manga_name}>
            <a href='# '>{data.name}</a>
          </h2>
          <h3 className={style.manga_category}>
            <a href='# '>{data.genre[0]?.name}</a>
          </h3>
        </div>
        <div className='manga_rating'>
          <RatingStars rating={data.rating} />
        </div>
      </div>

      <div className={style.manga_description}>{textLimiter(data.description, 308)}</div>

      <a className={style.readmore} href={data.url}>
        Continuar Lendo <FontAwesomeIcon icon={['fas', 'arrow-right']} />
      </a>
    </div>
  );
}
