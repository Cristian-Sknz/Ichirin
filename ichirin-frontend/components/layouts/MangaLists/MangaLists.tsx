import MangaList from '../Home/MangaList';
import MangaListsTitle from './MangaListsTitle';
import MangaListItem from '../Home/MangaList/MangaListItem';
import MangaData from '../../../lib/types';

import style from './MangaLists.module.css';

type MangaListsType = {
  mangas: MangaData[];
};

function MangaLists({ mangas }: MangaListsType) {
  return (
    <section className={style.manga_lists}>
      <h1>Mangá</h1>
      <MangaListsTitle title='174 RESULTADOS' />
      <MangaList>
        {mangas.slice(1, 9).map((item) => (
          <MangaListItem key={item.id} data={item} />
        ))}
      </MangaList>
    </section>
  );
}

export default MangaLists;