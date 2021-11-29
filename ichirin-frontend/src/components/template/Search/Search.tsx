import classNames from 'classnames';
import React, { forwardRef, useCallback, useImperativeHandle as useImperative, useRef, useState } from 'react';

import Searchbar from './Searchbar';
import SearchResults from './SearchList/SearchResults';
import { SearchBox } from './style';

export type SearchHandles = {
  toggleModal: () => void;
};

const Search = ({}, ref: React.RefObject<SearchHandles>) => {
  const inputRef = useRef<HTMLInputElement>(null);
  const [open, setOpen] = useState(false);
  const [results, setResults] = useState({
    values: [],
    loading: false,
  });

  useImperative(ref, () => ({ toggleModal: () => setOpen(!open) }));

  const handleInputChange = useCallback((value: string) => {
      if (value.length < 3) return;
      inputRef.current.blur();
      setResults({ values: [], loading: true });

      fetch(`/api/mangas/search?title=${value}`)
        .then(async (res) => {
          setResults({ values: await res.json(), loading: false });
        })
        .catch((err) => setResults({ values: [], loading: false }));
    },
    [setResults]
  );

  return (
    <SearchBox className={classNames({ active: open })}>
      <Searchbar
        onChange={handleInputChange}
        onClose={() => setOpen(false)}
        ref={inputRef}
      />
      <SearchResults loading={results.loading} items={results.values.slice(0, 10)} />
    </SearchBox>
  );
}

export default forwardRef(Search);
