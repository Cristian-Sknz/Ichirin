import FeaturedManga from './FeaturedManga';
import MangaList from './MangaList';
import MangaListItem from './MangaList/MangaListItem';

import MangaData from '../../../lib/types';
import SectionTitle from '../../models/SectionTitle';

import style from './Home.module.css';


type MangaProps = {
  mangas: MangaData[];
}

function FeaturedCompleted({ mangas }: MangaProps) {
  return (
    <section className={style.feature_completed}>
      <SectionTitle title={'Completos em Destaque'}/>
      <div className={style.item_container}>
        {mangas.length !== 0 && <FeaturedManga data={mangas[0]} />}
        <MangaList>
          {mangas.slice(1).map((item) => {
            return <MangaListItem key={item.id} data={item} />;
          })}
        </MangaList>
      </div>
    </section>
  );
}

export default FeaturedCompleted;
