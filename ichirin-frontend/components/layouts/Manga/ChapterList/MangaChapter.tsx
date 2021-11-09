import { memo } from 'react';

import style from '../Manga.module.css';
import { MangaChapterData } from '../MangaChapters';

type MangaChapterProps = {
    chapter: MangaChapterData;
}

function MangaChapter({chapter} : MangaChapterProps) {
    return (
        <li className={style.manga_chapter_item}>
            <a href={'# '}>
                <p>{`Capítulo ${chapter.chapterNumber} - ${chapter.chapterName}`}</p>
                <small>{chapter.releaseDate}</small>
            </a>
        </li>
    );
}

export default memo(MangaChapter);