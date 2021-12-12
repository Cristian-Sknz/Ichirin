import { GetStaticPaths, GetStaticProps } from 'next';
import Head from 'next/head';
import React from 'react';

import MangaChapters from '../../components/layouts/Manga/MangaChapters';
import MangaDescription from '../../components/layouts/Manga/MangaDescription';
import MangaPreview from '../../components/layouts/Manga/MangaPreview';
import Comments from '../../components/template/Comments/Comments';
import Footer from '../../components/template/Footer';
import PageHeaderProvider from '../../components/template/Contexts/header';
import Navbar from '../../components/template/Navbar';
import Search from '../../components/template/Search';
import Sidebar from '../../components/template/Sidebar/Sidebar';
import Topbar from '../../components/template/Topbar';
import { MangaTypes } from '../../lib/api';
import MangaData from '../../lib/types';
import { removeAccents } from '../../lib/Util';

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
