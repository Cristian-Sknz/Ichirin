import React from "react";
import MangaData from "../../../../../lib/types";
import TableContent from "../Table/TableContent";
import TableRow from "../Table/TableRow";

import style from '../Manga.module.css';

type MangaStatusProps = {
    manga: MangaData;
  };

function MangaStatus({manga} : MangaStatusProps) {
  return (
    <div className={style.manga_status}>
      <TableContent>
        <TableRow title='Ano de Lançamento' value={manga.releaseYear[0]} />
        <TableRow title='Status' value={manga.status.name} />
      </TableContent>
    </div>
  );
}

export default MangaStatus;
