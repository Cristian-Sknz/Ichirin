import { memo } from 'react';

import { MangaChapterData } from '../MangaChapters';
import { MangaChapterItem } from '../style';

type MangaChapterProps = {
  chapter: MangaChapterData;
};

const MangaChapter: React.FC<MangaChapterProps> = ({ chapter }) => {
  return (
    <MangaChapterItem>
      <a href={'# '}>
        <p>{`Capítulo ${chapter.chapterNumber} - ${chapter.chapterName}`}</p>
        <small>{chapter.releaseDate}</small>
      </a>
    </MangaChapterItem>
  );
};

export default memo(MangaChapter);
