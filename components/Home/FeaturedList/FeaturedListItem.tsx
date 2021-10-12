import RatingStars from "../Fragments/RatingStar";
import style from '../../../styles/Home.module.css';

const srcPreview =
  'https://ichirinnohanayuriscan.com/wp-content/uploads/2019/05/haru-to-midori-cover1-193x278.jpg';

export default function FeaturedListItem() {
  return (
    <li className={style.featured_list_item}>
      <div className={style.card_image}>
        <a href='# '>
          <img src={srcPreview} alt='' />
        </a>
      </div>
      <div className={style.manga_info_card}>
        <h2>Manga Title</h2>
        <h3>Category</h3>
      </div>
      <div className='manga_rating'>
        <RatingStars rating={4.5} />
      </div>
    </li>
  );
}
