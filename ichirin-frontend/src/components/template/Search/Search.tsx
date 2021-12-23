import React, { useContext, useEffect, useRef } from 'react';
import classNames from 'classnames';

import { PageHeaderContext } from '@ichirin/contexts/header';
import { SearchContextProvider } from '@ichirin/contexts/search';

import Searchbar from './Searchbar';
import SearchResults from './SearchList/SearchResults';
import { SearchBox } from './style';

const Search: React.FC = () => {
  const { search, toggleSearch } = useContext(PageHeaderContext);
  const inputRef = useRef<HTMLInputElement>(null);

  useEffect(() => {
    inputRef.current.focus();
  }, [search]);

  return (
    <SearchContextProvider>
      <SearchBox className={classNames({ active: search })}>
        <Searchbar onClose={toggleSearch} ref={inputRef} />
        <SearchResults />
      </SearchBox>
    </SearchContextProvider>
  );
};

export default Search;
