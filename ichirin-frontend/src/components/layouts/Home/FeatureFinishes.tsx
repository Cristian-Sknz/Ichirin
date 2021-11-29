import MangaData from '../../../lib/types';
import SectionTitle from '../../models/SectionTitle';
import FeaturedManga from './FeaturedManga';
import MangaList from './MangaList';
import MangaListItem from './MangaList/MangaListItem';

import { FeatureFinishes as StyledFeatureFinishes, ItemContainer } from './style';

type MangaProps = {
  mangas: MangaData[];
};

const FeatureFinishes: React.FC<MangaProps> = ({ mangas }) => {
  return (
    <StyledFeatureFinishes>
      <SectionTitle title={'Completos em Destaque'} />
      <ItemContainer>
        {mangas.length !== 0 && <FeaturedManga data={mangas[0]} />}
        <MangaList>
          {mangas.slice(1).map((item) => (
            <MangaListItem key={item.id} data={item} />
          ))}
        </MangaList>
      </ItemContainer>
    </StyledFeatureFinishes>
  );
};

export default FeatureFinishes;
