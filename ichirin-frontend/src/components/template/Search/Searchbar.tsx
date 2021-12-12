import { FontAwesomeIcon as Icon } from '@fortawesome/react-fontawesome';
import React, {
  ChangeEvent,
  forwardRef,
  MouseEventHandler,
  useContext,
  useEffect,
  useRef,
} from 'react';
import { SearchContext } from './Search';

import { CloseButton, SearchForm, SearchGroup, SearchInput } from './style';

type SearchbarProps = {
  onClose?: MouseEventHandler<HTMLButtonElement>;
};

type InputRef = React.RefObject<HTMLInputElement>;

const Searchbar = ({ onClose }: SearchbarProps, ref: InputRef) => {
  const { search, values } = useContext(SearchContext);
  const timeout = useRef<NodeJS.Timeout>(null);

  const onChangeEvent = (e: ChangeEvent<HTMLInputElement>) => {
    if (timeout.current != null) clearTimeout(timeout.current);
    timeout.current = setTimeout(() => search(e.target.value), 700);
  };

  useEffect(() => {
    if (ref.current) ref.current.blur();
  }, [ref, values]);

  return (
    <SearchForm onSubmit={(e) => e.preventDefault()}>
      <SearchGroup>
        <label htmlFor='search'>
          <Icon icon={['fas', 'search']} />
        </label>
        <SearchInput
          id='search'
          name='search'
          placeholder={'Digite para pesquisar'}
          onChange={onChangeEvent}
          autoComplete={'false'}
          ref={ref}
        />
      </SearchGroup>
      <CloseButton onClick={onClose}>Fechar</CloseButton>
    </SearchForm>
  );
};

export default forwardRef(Searchbar);
