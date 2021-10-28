import MangaData from '../../../lib/types';
import MangaStats from './MangaStats';

import style from './Manga.module.css';

type MangaPreviewProps = {
  manga: MangaData;
};

export default function MangaPreview({ manga }: MangaPreviewProps) {
  return (
    <article className={style.manga_section}>
      <div className={style.section_body}>

        <div className={style.manga_title}>
            {manga.isAdult && <span className={style.is_adult}>18+</span>}
          <h2>{manga.name}</h2>
        </div>

        <div className={style.manga_container}>
          <div className={style.manga_image}>
            <img src={manga.image_url} />
          </div>
          <MangaStats manga={manga} />
        </div>
        
      </div>
    </article>
  );
}
