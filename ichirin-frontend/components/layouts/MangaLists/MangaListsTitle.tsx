import React from 'react';
import { FontAwesomeIcon as Icon } from '@fortawesome/react-fontawesome';
import ListFilter from './Title/ListFilter';

import style from './MangaLists.module.css';

type MangaListsTitleProps = {
  title: string;
  children?: JSX.Element | JSX.Element[];
};

function MangaListsTitle({ title }: MangaListsTitleProps) {
  return (
    <div className={style.section_title}>
      <div>
        <div className={style.icon}>
          <Icon icon={['fas', 'star']} color={'white'} />
        </div>
        <h2>{title}</h2>
      </div>
      <ListFilter/>
    </div>
  );
}

export default MangaListsTitle;
