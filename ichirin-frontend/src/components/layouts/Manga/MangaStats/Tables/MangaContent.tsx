import React from 'react';

import MangaData from '../../../../../lib/types';
import TableContent from '../Table/TableContent';
import TableRow from '../Table/TableRow';
import { MangaContent as StyledMangaContent, RatingStarsStyled } from '../../style';

type MangaContentProps = {
  manga: MangaData;
};

const MangaContent: React.FC<MangaContentProps> = ({ manga }) => {
  return (
    <StyledMangaContent>
      <RatingStarsStyled rating={manga.rating} />
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
          {manga.genre.map(({ id, name }) => (
            <a key={id} href='# '>
              {name}
            </a>
          ))}
        </TableRow>
      </TableContent>
    </StyledMangaContent>
  );
};

export default MangaContent;
