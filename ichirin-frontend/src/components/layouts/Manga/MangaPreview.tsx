import classNames from 'classnames';
import Image from 'next/image';

import MangaData from '../../../lib/types';
import MangaStats from './MangaStats';
import {
  MangaAgeRating,
  MangaArticle,
  MangaArticleContainer,
  MangaContainer,
  MangaImageContainer,
  MangaName,
  MangaTitle,
} from './style';

type MangaPreviewProps = {
  manga: MangaData;
};

const MangaPreview : React.FC<MangaPreviewProps> = ({ manga }) => {
  return (
    <MangaArticle>
      <MangaArticleContainer>

        <MangaTitle>
          <MangaAgeRating className={classNames({ 'isAdult': manga.isAdult })}>
            18+
          </MangaAgeRating>
          <MangaName>{manga.name}</MangaName>
        </MangaTitle>

        <MangaContainer>
          <MangaImageContainer>
            <Image
              src={manga.image_url}
              width={193}
              height={278}
              alt={manga.name}
              layout={'responsive'}
            />
          </MangaImageContainer>

          <MangaStats manga={manga} />
        </MangaContainer>

      </MangaArticleContainer>
    </MangaArticle>
  );
}

export default MangaPreview;
