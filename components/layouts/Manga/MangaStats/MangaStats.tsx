import MangaData from '../../../../lib/types';
import TableContent from './Table/TableContent';
import TableRow from './Table/TableRow';

import RatingStars from '../../../models/RatingStar';
import style from '../Manga.module.css';

type MangaStatsProps = {
  manga: MangaData;
};

export default function MangaStats({ manga }: MangaStatsProps) {
  return (
    <div className={style.manga_stats}>
        <div className={style.manga_stats_box}>
        <div className={style.manga_content}>
          <RatingStars className={style.rating_stars} rating={manga.rating}/>
          <TableContent>
          {manga.alternative_names[0] && (
              <TableRow
                title='Nome alternativo'
                value={manga.alternative_names.join(', ')}
              />
            )}
            <TableRow title='Author(es)' value={manga.authors.join(', ')} />
            {manga.artists[0] && (
              <TableRow title='Artista' value={manga.artists.join(', ')} />
            )}
            <TableRow title='Tipo' value={manga.type.name} />
            <TableRow title='Categoria(s)'>
              {manga.genre.map(({ id ,name }) => (<a key={id} href='# '>{name}</a>))}
            </TableRow>
          </TableContent>
        </div>
        <div className={style.manga_status}>
            <TableContent>
                <TableRow title="Ano de Lançamento" value={manga.releaseYear[0]}/>
                <TableRow title="Status" value={manga.status.name}/>
            </TableContent>
        </div>
      </div>
      <div className={style.chapter_buttons}>
          <div className={style.chapter_button}>Primeiro Capitulo</div>
          <div className={style.chapter_button}>Ultimo Capitulo</div>
        </div>
    </div>
  );
}
