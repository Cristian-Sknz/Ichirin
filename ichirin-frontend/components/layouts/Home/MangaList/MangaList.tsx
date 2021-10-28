import style from '../Home.module.css'

type MangaListProps = {
    children: JSX.Element | JSX.Element[];
}

export default function MangaList({children} : MangaListProps) {
    return (<div className={style.manga_list_container}>
        <ul className={style.manga_list}>
            {children}
        </ul>
    </div>);
}