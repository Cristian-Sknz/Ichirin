import React from 'react';

import Head from 'next/head';
import Image from 'next/image';

import AnchorLink from '../components/models/AnchorLink';
import { ErrorContainer, ErrorParagraph, ErrorTitle } from '../styles/error';

const Error404Page: React.FC = () => {
  return (
    <>
      <Head>
        <title>404: Pagina não encontrada - Ichirin no Hana Yuri</title>
        <meta
          name='description'
          content='Pagina não encontrada! - Ichirin no Hana Yuri'
        />
      </Head>
      <ErrorContainer>
        <AnchorLink href={'/'}>
          <Image
            src={'/logo.svg'}
            className={'logo'}
            alt={'Ichirin Logo'}
            width={512}
            height={87}
          />
        </AnchorLink>
        <ErrorTitle>Ooops! Página não encontrada.</ErrorTitle>
        <ErrorParagraph>
          Desculpe, a página que você está procurando não foi encontrada! É possível
          que a página tenha sido excluída ou você digitou incorretamente a URL.
        </ErrorParagraph>

        <AnchorLink className={'home-btn'} href={'/'}>
          Voltar para o inicio
        </AnchorLink>
      </ErrorContainer>
    </>
  );
};

export default Error404Page;
