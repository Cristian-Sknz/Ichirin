import MangaData from '../../../lib/types';
import MangaList from '../Home/MangaList';
import MangaListItem from '../Home/MangaList/MangaListItem';
import MangaListsTitle from './MangaListsTitle';
import { MangaLists as StyledMangaLists, MangaTypeTitle } from './style';

type MangaListsType = {
  mangas: MangaData[];
};

const MangaLists: React.FC<MangaListsType> = ({ mangas }) => {
  return (
    <StyledMangaLists>
      <MangaTypeTitle>Mangá</MangaTypeTitle>
      <MangaListsTitle title='174 RESULTADOS' />
      <MangaList>
        {mangas.slice(1, 9).map((item) => (
          <MangaListItem key={item.id} data={item} />
        ))}
      </MangaList>
    </StyledMangaLists>
  );
};

export default MangaLists;
