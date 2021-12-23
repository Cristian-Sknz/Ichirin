import React from 'react';

import MangaData from '@ichirin/lib/types';

import TableContent from '../Table/TableContent';
import TableRow from '../Table/TableRow';
import { MangaStatus as StyledMangaStatus } from '../style';

type MangaStatusProps = {
  manga: MangaData;
};

const MangaStatus: React.FC<MangaStatusProps> = ({ manga }) => {
  return (
    <StyledMangaStatus>
      <TableContent>
        <TableRow title='Ano de Lançamento' value={manga.releaseYear[0]} />
        <TableRow title='Status' value={manga.status.name} />
      </TableContent>
    </StyledMangaStatus>
  );
};

export default MangaStatus;
