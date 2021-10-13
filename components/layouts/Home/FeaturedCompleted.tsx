import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import FeaturedManga from './FeaturedManga';
import MangaList from './MangaList';

import style from './Home.module.css';
import MangaListItem from './MangaList/MangaListItem';
import { createManga } from './MangaList/MangaList';

function createFeaturedManga() {
  const manga = createManga();
  manga.description =
    'Lorem ipsum dolor sit amet consectetur, adipisicing elit. Rerum itaque distinctio, dolores est vel dignissimos magni magnam illum quos, ullam repudiandae ut assumenda delectus obcaecati cum quia aspernatur, suscipit aut!';
  manga.image_url =
    'https://ichirinnohanayuriscan.com/wp-content/uploads/2020/04/cover-193x278.jpg';
  return manga;
}

export default function FeaturedCompleted() {
  const mangas = [];
  for (let i = 1; i <= 8; i++) {
    mangas.push(<MangaListItem key={i} data={createManga()} />);
  }

  return (
    <section className={style.feature_completed}>
      <div className={style.section_title}>
        <div className={style.icon}>
          <FontAwesomeIcon icon={['fas', 'star']} color={'white'} />
        </div>
        <h2>Completos em Destaque</h2>
      </div>

      <div className={style.item_container}>
        <FeaturedManga data={createFeaturedManga()} />
        <MangaList>{mangas}</MangaList>
      </div>
    </section>
  );
}
