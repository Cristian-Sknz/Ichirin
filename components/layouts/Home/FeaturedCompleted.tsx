import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

import FeaturedManga from "./FeaturedManga";
import MangaList from "./MangaList";

import style from './Home.module.css'
import MangaListItem from "./MangaList/MangaListItem";
import { createManga } from "./MangaList/MangaList";


export default function FeaturedCompleted() {
    const mangas = [];
    for (let i = 1; i <= 8; i++) {
        mangas.push(<MangaListItem data={createManga()}/>);
    }


    return (
    <section className={style.feature_completed}>
        <div className={style.section_title}>
            <div className={style.icon}>
                <FontAwesomeIcon icon={['fas', 'star']} color={'white'}/>
            </div>
            <h2>Completos em Destaque</h2>
        </div>

        <div className={style.item_container}>
            <FeaturedManga />
            <MangaList>
                {mangas}
            </MangaList>
        </div>

    </section>
    );
}