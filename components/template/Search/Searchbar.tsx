import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { ChangeEvent, MouseEventHandler, useRef, useState } from 'react';
import style from './Search.module.css';

type SearchbarProps = {
  onChange?: Function;
  onClose?: MouseEventHandler<HTMLButtonElement>;
};

export default function Searchbar({ onChange, onClose }: SearchbarProps) {
  const timeout = useRef<NodeJS.Timeout>(null);

  function onChangeEvent(e: ChangeEvent<HTMLInputElement>) {
    if (timeout.current != null) clearTimeout(timeout.current);
    timeout.current = setTimeout(() => onChange.call(null, e.target.value), 1000);
  }

  return (
    <form className={style.search_form} onSubmit={(e) => e.preventDefault()}>
      <div className={style.search_group}>
        <label htmlFor='search'>
          <FontAwesomeIcon icon={['fas', 'search']} />
        </label>
        <input
          id='search'
          name='search'
          placeholder={'Digite para pesquisar'}
          onChange={onChangeEvent}
          autoComplete={'false'}
        />
      </div>
      <button className={style.submit_button} onClick={onClose}>Fechar</button>
    </form>
  );
}
