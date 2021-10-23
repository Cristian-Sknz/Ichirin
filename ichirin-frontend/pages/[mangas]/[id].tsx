import { GetStaticPaths, GetStaticProps } from 'next';
import React from 'react';
import Head from 'next/head';

import Navbar from '../../components/template/Navbar';
import Topbar from '../../components/template/Topbar';
import Footer from '../../components/template/Footer';

import MangaPreview from '../../components/layouts/Manga/MangaPreview';
import MangaDescription from '../../components/layouts/Manga/MangaDescription';
import MangaChapters from '../../components/layouts/Manga/MangaChapters';
import MangaData from '../../lib/types';

import { MangaTypes } from '../../lib/api';
import { removeAccents } from '../../lib/Util';

type ObraProps = {
  manga: MangaData;
};

export default function Obra({ manga }: ObraProps) {
  return (
    <>
      <Head>
        <title>{`${manga?.name} - Ichirin no Hana Yuri`}</title>
        <meta
          name='description'
          content={`Leia o manga ${manga?.name} online.`}/>
        <link rel='icon' href='/favicon.ico' />
      </Head>

      <>
        <Navbar />
        <Topbar />
        <>
          <MangaPreview manga={manga} />
          <MangaDescription manga={manga} />
          <MangaChapters chapters={[]} />
        </>
        <Footer />
      </>
    </>
  );
}

export const getStaticProps: GetStaticProps = async (context) => {
  const { id, mangas } = context.params;
  const type = identifyType(mangas as string);
  if (!type) {
    return { notFound: true };
  }

  const res = await fetch(`http://localhost:3000/api/mangas/${id}?type=${type}`);
  if (res.status === 404) {
    return { notFound: true };
  }

  const manga: MangaData = await res.json();
  return { props: { manga } };
};

export const getStaticPaths: GetStaticPaths = async () => {
  return {
    paths: [],
    fallback: 'blocking',
  };
};

function identifyType(type: string): string | undefined {
  return MangaTypes.map(({ name }) => removeAccents(name)).filter(
    (name) => removeAccents(name).toLowerCase() == type.toLowerCase()
  )[0];
}
