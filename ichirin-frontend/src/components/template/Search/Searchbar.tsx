import { FontAwesomeIcon as Icon } from '@fortawesome/react-fontawesome';
import React, { ChangeEvent, forwardRef, MouseEventHandler, useRef } from 'react';

import { CloseButton, SearchForm, SearchGroup, SearchInput } from './style';

type SearchbarProps = {
  onChange?: (e : string) => void;
  onClose?: MouseEventHandler<HTMLButtonElement>;
};

const Searchbar = ({ onChange, onClose }: SearchbarProps, ref : React.RefObject<HTMLInputElement>) => {
  const timeout = useRef<NodeJS.Timeout>(null);

  const onChangeEvent = (e: ChangeEvent<HTMLInputElement>) => {
    if (timeout.current != null) clearTimeout(timeout.current);
    timeout.current = setTimeout(() => onChange(e.target.value), 700);
  }

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
}

export default forwardRef(Searchbar);
