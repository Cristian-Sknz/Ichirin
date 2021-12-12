import React from 'react';

import Head from 'next/head';
import { GetStaticPaths, GetStaticProps, InferGetStaticPropsType } from 'next';

import MangaLists from '../../components/layouts/MangaLists/MangaLists';
import Navbar from '../../components/template/Navbar';
import Topbar from '../../components/template/Topbar';
import MangaData from '../../lib/types';
import PageHeaderProvider from '../../components/template/header';
import Search from '../../components/template/Search';
import Sidebar from '../../components/template/Sidebar/Sidebar';
import Footer from '../../components/template/Footer';

type MangaTypeProps = InferGetStaticPropsType<typeof getStaticProps>;

const MangaType: React.FC<MangaTypeProps> = (props) => {
  return (
    <>
      <Head>
        <title>Mangas - Ichirin no Hana Yuri</title>
        <meta name='description' content='Pagina inicial do Ichirin no Hana Yuri' />
      </Head>
      <>
        <PageHeaderProvider>
          <Navbar />
          <Topbar />
          <Search />
          <Sidebar />
        </PageHeaderProvider>
        <MangaLists mangas={props.value} />
        <Footer/>
      </>
    </>
  );
};

export const getStaticProps: GetStaticProps = async (context) => {
  let mangas: MangaData[] = new Array();
  try {
    const res = await fetch('http://localhost:3000/api/mangas');
    mangas = await res.json();
    mangas = mangas.slice(0, 9);
  } catch (ignored) {}

  return { props: { value: mangas } };
};

export const getStaticPaths: GetStaticPaths = async () => {
  const paths = ['mangas', 'manhuas', 'manhwas', 'webtoon', 'nsfw'];
  return {
    paths: paths.map((path) => ({ params: { mangas: path } })),
    fallback: false,
  };
};

export default MangaType;
