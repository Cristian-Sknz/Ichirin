import React from 'react';

import { FontAwesomeIcon as Icon } from '@fortawesome/react-fontawesome';
import ListFilter from './Title/ListFilter';

import { MangaListsTitle as ListsTitle, TitleContainer } from './style';

type MangaListsTitleProps = {
  title: string;
  children?: JSX.Element | JSX.Element[];
};

const MangaListsTitle: React.FC<MangaListsTitleProps> = ({ title }) => {
  return (
    <ListsTitle>
      <TitleContainer>
        <div className={'icon'}>
          <Icon icon={['fas', 'star']} color={'white'} />
        </div>
        <h2>{title}</h2>
      </TitleContainer>
      <ListFilter />
    </ListsTitle>
  );
};

export default MangaListsTitle;
