import RatingStars from '../Fragments/RatingStar';
import style from '../../../styles/Home.module.css';

type MangaCategory = {
  id: number;
  name: string;
};

type MangaType = {
  id: number;
  name: string;
};

type FeaturedItemProps = {
  id: number;
  name: string;
  image_url: string;
  description: string;
  type: MangaType;
  category: MangaCategory;
  rating: number;
};

const srcPreview =
  'https://ichirinnohanayuriscan.com/wp-content/uploads/2020/04/cover-193x278.jpg';

export default function FeaturedManga() {
  return (
    <div className={style.featured_item_container}>
      <div className={style.manga_image}>
        <img src={srcPreview} alt='manga image' />
      </div>
      <div className={style.manga_info}>
        <div className={style.manga_title}>
          <h2>Manga name</h2>
          <h3>Manga category</h3>
        </div>
        <div className='manga_rating'>
          <RatingStars rating={4.5} />
        </div>
      </div>
      <div className={style.manga_description}>
        Lorem ipsum dolor sit amet consectetur adipisicing elit. Assumenda,
        veniam! Repudiandae sint hic doloremque, molestias voluptate rerum
        doloribus consectetur quod magnam soluta perspiciatis impedit quos esse
        officia explicabo distinctio aliquam?
      </div>
    </div>
  );
}
