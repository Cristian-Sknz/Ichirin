import React, { useContext } from 'react';
import classNames from 'classnames';

import MangaData from '@ichirin/lib/types';
import { SearchContext } from '@ichirin/contexts/search';
import LoadingRing from '@template/Loading/LoadingRing';

import SearchItem from './SearchItem';
import { EmptyItem, SearchResults as StyledSearchResults } from '../style';

type SearchResultsProps = {
  items: MangaData[];
  loading: boolean;
};

const SearchResults: React.FC = () => {
  const {values, loading} = useContext(SearchContext);
  return (
    <StyledSearchResults>
      {values.length != 0 &&
        values.map((item) => <SearchItem item={item} key={item.id} />)}
      <EmptyItem className={classNames({ active: values.length == 0 })}>
        {!loading ? <h3>Nenhum resultado foi encontrado!</h3> : <LoadingRing />}
      </EmptyItem>
    </StyledSearchResults>
  );
};

export default SearchResults;
