import React, { useCallback, useState } from 'react';
import MangaData from '@ichirin/lib/types';

type SearchContextType = {
  values: MangaData[];
  loading: boolean;
  search(value: string): void;
};

export const SearchContext = React.createContext<SearchContextType>(
  {} as SearchContextType
);

export function SearchContextProvider({ children }) {
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