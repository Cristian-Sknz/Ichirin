import classNames from 'classnames';
import React, { useCallback, useContext, useEffect, useRef, useState } from 'react';
import MangaData from '../../../lib/types';
import { PageHeaderContext } from '../header';

import Searchbar from './Searchbar';
import SearchResults from './SearchList/SearchResults';
import { SearchBox } from './style';

type SearchContextType = {
  values: MangaData[];
  loading: boolean;
  search(value: string): void;
};

export const SearchContext = React.createContext<SearchContextType>(
  {} as SearchContextType
);

function SearchContextProvider({ children }) {
  const [values, setValues] = useState<MangaData[]>([]);
  const [loading, setLoading] = useState<boolean>(false);

  const search = useCallback((value: string) => {
    if (value.length < 3) return;
    setValues([]);
    setLoading(true);
    fetch(`/api/mangas/search?title=${value}`)
      .then(async (res) => {
        setValues(await res.json());
        setLoading(false);
      })
      .catch((err) => setLoading(false));
  }, []);

  return (
    <SearchContext.Provider
      value={{
        values,
        loading,
        search,
      }}
    >
      {children}
    </SearchContext.Provider>
  );
}

const Search: React.FC = () => {
  const { search, toggleSearch } = useContext(PageHeaderContext);
  const inputRef = useRef<HTMLInputElement>(null);

  useEffect(() => {
    inputRef.current.focus();
  }, [search]);

  return (
    <SearchContextProvider>
      <SearchBox className={classNames({ active: search })}>
        <Searchbar
          onClose={toggleSearch}
          ref={inputRef}
        />
        <SearchResults/>
      </SearchBox>
    </SearchContextProvider>
  );
};

export default Search;
