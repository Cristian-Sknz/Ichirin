import React from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import style from './Home.module.css'
import MangaList from './MangaList';
import MangaListItem from './MangaList/MangaListItem';
import { createManga } from './MangaList/MangaList';


export default function LastMangaUpdates() {
    const mangas = [];
    for (let i = 1; i <= 12; i++) {
        mangas.push(<MangaListItem data={createManga()}/>);
    }
    return (
    <section className={style.last_updates}>
        <div className={style.section_title}>
            <div className={style.icon}>
                <FontAwesomeIcon icon={['fas', 'star']} color={'white'}/>
            </div>
            <h2>Ultimas Atualizações</h2>
        </div>
        <div className={style.last_updates_container}>
            <MangaList>
                {mangas}
            </MangaList>
        </div>
    </section>
    );
}