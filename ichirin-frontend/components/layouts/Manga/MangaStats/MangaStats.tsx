import React from 'react';

import MangaData from '../../../../lib/types';
import MangaContent from './Tables/MangaContent';
import MangaStatus from './Tables/MangaStatus';

import style from '../Manga.module.css';

type MangaStatsProps = {
  manga: MangaData;
};

function MangaStats({ manga }: MangaStatsProps) {
  return (
    <div className={style.manga_stats}>
      <div className={style.manga_stats_box}>
        <MangaContent manga={manga} />
        <MangaStatus manga={manga} />
      </div>
      <div className={style.chapter_buttons}>
        <div className={style.chapter_button}>Primeiro Capitulo</div>
        <div className={style.chapter_button}>Ultimo Capitulo</div>
      </div>
    </div>
  );
}

export default MangaStats;