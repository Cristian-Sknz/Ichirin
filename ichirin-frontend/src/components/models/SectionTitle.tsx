import React from 'react';
import { FontAwesomeIcon as Icon } from '@fortawesome/react-fontawesome';

import style from './Models.module.css';

type SectionTitleProps = {
  title: string;
  children?: JSX.Element | JSX.Element[];
};

const SectionTitle: React.FC<SectionTitleProps> = ({ title, children }) => {
  return (
    <div className={style.section_title}>
      <div className={style.icon}>
        <Icon icon={['fas', 'star']} color={'white'} />
      </div>
      <h2>{title}</h2>
      {children}
    </div>
  );
};

export default SectionTitle;
