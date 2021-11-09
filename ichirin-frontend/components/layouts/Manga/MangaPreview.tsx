import Image from 'next/image'

import MangaData from '../../../lib/types';
import MangaStats from './MangaStats';

import style from './Manga.module.css';

type MangaPreviewProps = {
  manga: MangaData;
};

function MangaPreview({ manga }: MangaPreviewProps) {
  return (
    <article className={style.manga_section}>
      <div className={style.section_body}>

        <div className={style.manga_title}>
            {manga.isAdult && <span className={style.is_adult}>18+</span>}
          <h2>{manga.name}</h2>
        </div>

        <div className={style.manga_container}>
          <div className={style.manga_image}>
            <Image src={manga.image_url} 
              width={193}
              height={278}
              alt={manga.name}
              layout={'responsive'}
            />
          </div>
          <MangaStats manga={manga} />
        </div>
        
      </div>
    </article>
  );
}

export default MangaPreview;