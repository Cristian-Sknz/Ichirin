import classNames from 'classnames';
import { useContext, useEffect } from 'react';

import MangaData from '../../../../lib/types';
import { SearchContext } from '../../Contexts/search';
import LoadingRing from '../../Loading/LoadingRing';
import { EmptyItem, SearchResults as StyledSearchResults } from '../style';
import SearchItem from './SearchItem';

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
