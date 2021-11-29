import SectionTitle from '../../models/SectionTitle';
import MangaChapter from './ChapterList/MangaChapter';

import { MangaChapterList, MangaChapters as StyledMangaChapters } from './style';

export type MangaChapterData = {
  mangaId: number;
  chapterNumber: number;
  chapterName: string;
  releaseDate: string;
};

type MangaChaptersProps = {
  chapters: MangaChapterData[];
};

const example : MangaChapterData[] = [
  {
    chapterName: 'Exemplo de Capitulo',
    chapterNumber: 1,
    mangaId: 1,
    releaseDate: new Date().toLocaleDateString()
  }
];

const MangaChapters: React.FC<MangaChaptersProps> = ({ chapters }) => {
  const c = example; 
  return (
    <StyledMangaChapters>
      <SectionTitle title={'Capítulos'} />
      {c.length == 0 && (
        <h3>Opss.. não tem nenhum capitulo disponivel ainda!</h3>
      )}
      <MangaChapterList>
        {c.map((chapter) => (
          <MangaChapter key={chapter.chapterNumber} chapter={chapter} />
        ))}
      </MangaChapterList>
      {/* Botão de mais capitulos */}
    </StyledMangaChapters>
  );
}

export default MangaChapters;