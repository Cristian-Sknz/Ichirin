import React from 'react';
import AnchorLink from '../components/models/AnchorLink';
import style from '../styles/Error.module.css';

export default function Error404Page() {
  return (
    <div className={style.error_container}>
      <AnchorLink href={'/'}>
        <img src={'/logo.svg'} className={style.logo} />
      </AnchorLink>
      <h1>Ooops! Página não encontrada.</h1>
      <p>
        Desculpe, a página que você está procurando não foi encontrada! É
        possível que a página tenha sido excluída ou você digitou incorretamente
        a URL.
      </p>
      <AnchorLink className={style.home_button} href={'/'}>
        Voltar para o inicio
      </AnchorLink>
    </div>
  );
}
