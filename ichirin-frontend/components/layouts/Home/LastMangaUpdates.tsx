import React, { useEffect, useState } from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import MangaList from './MangaList';
import MangaListItem from './MangaList/MangaListItem';
import MangaData from '../../../lib/types';
import SectionTitle from '../../models/SectionTitle';

import style from './Home.module.css'

type MangaProps = {
    mangas: MangaData[];
}

export default function LastMangaUpdates({mangas} : MangaProps) {
    return (<section className={style.last_updates}>
        <SectionTitle title={'Ultimas Atualizações'}/>
        <div className={style.last_updates_container}>
            <MangaList>
                {mangas.map((item) => {
                    return <MangaListItem key={item.id} data={item}/>
                })}
            </MangaList>
        </div>
    </section>
    );
}