import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { ChangeEvent, useState } from 'react';
import style from './Search.module.css';

type SearchbarProps = {
  onChange?: Function;
  onClose?: Function;
};

export default function Searchbar({ onChange, onClose }: SearchbarProps) {
  var timeout;

  function onChangeEvent(e: ChangeEvent<HTMLInputElement>) {
    if (timeout != null) clearTimeout(timeout);
    timeout = setTimeout(() => onChange.call(null, e.target.value), 1000);
  }

  return (
    <form className={style.search_form}>
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
      <button className={style.submit_button}>Fechar</button>
    </form>
  );
}
