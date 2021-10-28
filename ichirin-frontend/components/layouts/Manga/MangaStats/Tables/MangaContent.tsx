import React from "react";
import TableContent from "../Table/TableContent";
import TableRow from "../Table/TableRow";

import style from '../../Manga.module.css'
import MangaData from "../../../../../lib/types";
import RatingStars from "../../../../models/RatingStar";

type MangaContentProps = {
  manga: MangaData;
}

function MangaContent({manga} : MangaContentProps) {
    return (
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
            {manga.artists[0] && (<TableRow title='Artista' value={manga.artists.join(', ')} />)}
            <TableRow title='Tipo' value={manga.type.name} />
            <TableRow title='Categoria(s)'>
              {manga.genre.map(({ id ,name }) => (<a key={id} href='# '>{name}</a>))}
            </TableRow>
          </TableContent>
        </div>
    );
}

export default MangaContent;