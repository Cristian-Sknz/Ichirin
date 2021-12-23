import React from 'react';

import MangaData from '@ichirin/lib/types';
import SectionTitle from '@models/SectionTitle';

import MangaList from './MangaList';
import MangaListItem from './MangaList/MangaListItem';
import { LastMangaUpdates as MangaUpdates, MangaUpdatesContainer } from './style';

type MangaProps = {
  mangas: MangaData[];
};

const LastMangaUpdates : React.FC<MangaProps> = ({ mangas }) => {
  return (
    <MangaUpdates>
      <SectionTitle title={'Ultimas Atualizações'} />
      <MangaUpdatesContainer>
        <MangaList>
          {mangas.map((item) => (
            <MangaListItem key={item.id} data={item} />
          ))}
        </MangaList>
      </MangaUpdatesContainer>
    </MangaUpdates>
  );
}
export default LastMangaUpdates;
