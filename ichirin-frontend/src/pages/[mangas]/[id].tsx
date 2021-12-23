import React from 'react';
import Head from 'next/head';
import { GetStaticPaths, GetStaticProps } from 'next';

import MangaChapters from '@layouts/Manga/MangaChapters';
import MangaDescription from '@layouts/Manga/MangaDescription';
import MangaPreview from '@layouts/Manga/MangaPreview';
import Comments from '@template/Comments/Comments';
import Footer from '@template/Footer';
import Navbar from '@template/Navbar';
import Search from '@template/Search';
import Sidebar from '@template/Sidebar/Sidebar';
import Topbar from '@template/Topbar';

import PageHeaderProvider from '@ichirin/contexts/header';

import { MangaTypes } from '@ichirin/lib/api';
import MangaData from '@ichirin/lib/types';
import { removeAccents } from '@ichirin/lib/Util';

type ObraProps = {
  manga: MangaData;
};

const Obra: React.FC<ObraProps> = ({ manga }) => {
  return (
    <>
      <Head>
        <title>{`${manga?.name} - Ichirin no Hana Yuri`}</title>
        <meta name='description' content={`Leia o manga ${manga?.name} online.`} />
        <link rel='icon' href='/favicon.ico' />
      </Head>
      <>
        <PageHeaderProvider>
          <Navbar />
          <Topbar />
          <Search />
          <Sidebar />
        </PageHeaderProvider>
        <MangaPreview manga={manga} />
        <MangaDescription manga={manga} />
        <MangaChapters chapters={[]} />
        <Comments />
        <Footer />
      </>
    </>
  );
};

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

export default Obra;
