import style from '../Home.module.css'
import MangaListItem from './MangaListItem';

type MangaListProps = {
    children: MangaListItem[];
}

export default function MangaList({children}) {
    return (<div className={style.manga_list_container}>
        <ul className={style.manga_list}>
            {children}
        </ul>
    </div>);
}