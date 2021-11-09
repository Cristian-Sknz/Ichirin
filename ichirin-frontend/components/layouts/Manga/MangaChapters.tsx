import SectionTitle from '../../models/SectionTitle';
import MangaChapter from './ChapterList/MangaChapter';

import style from './Manga.module.css';

export type MangaChapterData = {
  mangaId: number;
  chapterNumber: number;
  chapterName: string;
  releaseDate: string;
};

type MangaChaptersProps = {
  chapters: MangaChapterData[];
};

function MangaChapters({ chapters }: MangaChaptersProps) {
  return (
    <section className={style.manga_chapters}>
      <SectionTitle title={'Capítulos'} />
      {chapters.length == 0 && (
        <h3>Opss.. não tem nenhum capitulo disponivel ainda!</h3>
      )}
      <ul className={style.manga_chapters_list}>
        {chapters.map((chapter) => (
          <MangaChapter key={chapter.chapterNumber} chapter={chapter} />
        ))}
      </ul>
      {/* Botão de mais capitulos */}
    </section>
  );
}

export default MangaChapters;