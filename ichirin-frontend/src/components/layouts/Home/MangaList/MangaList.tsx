import React from 'react';
import { MangaListContainer, MangaList as StyledMangaList } from '../style';

type MangaListProps = {
  children: JSX.Element | JSX.Element[];
};

const MangaList: React.FC<MangaListProps> = ({ children }) => {
  return (
    <MangaListContainer>
      <StyledMangaList>{children}</StyledMangaList>
    </MangaListContainer>
  );
};

export default MangaList;
