import React from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import style from './Models.module.css';

type SectionTitleProps = {
    title: string;
    children?: JSX.Element | JSX.Element[];
}

export default function SectionTitle({title, children} : SectionTitleProps) {
  return (
    <div className={style.section_title}>
      <div className={style.icon}>
        <FontAwesomeIcon icon={['fas', 'star']} color={'white'} />
      </div>
      <h2>{title}</h2>
      {children}
    </div>
  );
}
