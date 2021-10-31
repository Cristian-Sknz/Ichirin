import React from 'react';
import Head from 'next/head';
import Image from 'next/image'
import AnchorLink from '../components/models/AnchorLink';
import style from '../styles/Error.module.css';

function Error404Page() {
  return (
    <>
      <Head>
        <title>404: Pagina não encontrada - Ichirin no Hana Yuri</title>
        <meta
          name='description'
          content='Pagina não encontrada! - Ichirin no Hana Yuri'/>
      </Head>
      <div className={style.error_container}>
        <AnchorLink href={'/'}>
          <Image src={'/logo.svg'} 
            className={style.logo} 
            alt={'Ichirin Logo'}
            width={512}
            height={87}
            />
        </AnchorLink>
        <h1>Ooops! Página não encontrada.</h1>
        <p>
          Desculpe, a página que você está procurando não foi encontrada! É
          possível que a página tenha sido excluída ou você digitou
          incorretamente a URL.
        </p>
        <AnchorLink className={style.home_button} href={'/'}>
          Voltar para o inicio
        </AnchorLink>
      </div>
    </>
  );
}

export default Error404Page;