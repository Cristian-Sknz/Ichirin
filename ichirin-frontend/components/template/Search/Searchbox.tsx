import React, {
  forwardRef,
  useCallback,
  useImperativeHandle,
  useRef,
  useState,
} from 'react';

import style from './Search.module.css';
import Searchbar from './Searchbar';
import SearchResults from './SearchList/SearchResults';

export type SearchBoxHandles = {
  toggleModal: () => void;
};

function Searchbox({}, ref: React.RefObject<SearchBoxHandles>) {
  const [open, setOpen] = useState(false);
  const [results, setResults] = useState({
    values: [],
    loading: false,
  });
  const inputRef = useRef<HTMLInputElement>(null);

  useImperativeHandle(ref, () => ({ 
    toggleModal: () => setOpen(!open) 
  }));

  const handleInputChange = useCallback((value: string) => {
    if (value.length < 3) return;
    inputRef.current.blur();
    setResults({ values: [], loading: true });
    fetch(`/api/mangas/search?title=${value}`)
      .then(async (res) => {
          setResults({ values: await res.json(), loading: false }); 
      })
      .catch((err) => setResults({values: [], loading: false}));
  }, [setResults]);

  return (
    <div className={`${style.searchbox} ${open ? style.active : ''}`}>
      <Searchbar 
        onChange={handleInputChange} 
        onClose={() => setOpen(false)} 
        ref={inputRef} />
      <SearchResults
        loading={results.loading}
        items={results.values.slice(0, 10)} />
    </div>
  );
}

export default forwardRef(Searchbox);
