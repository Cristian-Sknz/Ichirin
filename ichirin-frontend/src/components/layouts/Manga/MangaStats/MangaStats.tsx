import React from 'react';

import MangaData from '@ichirin/lib/types';

import MangaContent from './Tables/MangaContent';
import MangaStatus from './Tables/MangaStatus';
import {
  ChapterButton,
  ChapterButtons,
  MangaStats as StyledMangaStats,
  MangaStatsContainer,
} from './style';

type MangaStatsProps = {
  manga: MangaData;
};

const MangaStats : React.FC<MangaStatsProps> = ({ manga }) => {
  return (
    <StyledMangaStats>
      <MangaStatsContainer>
        <MangaContent manga={manga} />
        <MangaStatus manga={manga} />
      </MangaStatsContainer>

      <ChapterButtons>
        <ChapterButton>Primeiro Capitulo</ChapterButton>
        <ChapterButton>Ultimo Capitulo</ChapterButton>
      </ChapterButtons>
    </StyledMangaStats>
  );
}

export default MangaStats;
