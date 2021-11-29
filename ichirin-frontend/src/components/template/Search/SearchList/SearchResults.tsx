import classNames from 'classnames';

import MangaData from '../../../../lib/types';
import LoadingRing from '../../Loading/LoadingRing';
import { EmptyItem, SearchResults as StyledSearchResults } from '../style';
import SearchItem from './SearchItem';

type SearchResultsProps = {
  items: MangaData[];
  loading: boolean;
};

const SearchResults: React.FC<SearchResultsProps> = ({ items, loading }) => {
  return (
    <StyledSearchResults>
      {items.length != 0 &&
        items.map((item) => <SearchItem item={item} key={item.id} />)}
      <EmptyItem className={classNames({ active: items.length == 0 })}>
        {!loading ? <h3>Nenhum resultado foi encontrado!</h3> : <LoadingRing />}
      </EmptyItem>
    </StyledSearchResults>
  );
};

export default SearchResults;
