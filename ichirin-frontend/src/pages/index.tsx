import React from 'react';
import Head from 'next/head';
import { InferGetStaticPropsType } from 'next';

import FeatureCarrousel from '../components/layouts/Home/FeatureCarrousel';
import FeatureFinishes from '../components/layouts/Home/FeatureFinishes';
import LastMangaUpdates from '../components/layouts/Home/LastMangaUpdates';
import Footer from '../components/template/Footer';
import Navbar from '../components/template/Navbar';
import Topbar from '../components/template/Topbar';
import MangaData from '../lib/types';
import PageHeaderProvider from '../components/template/Contexts/header';
import Search from '../components/template/Search';
import Sidebar from '../components/template/Sidebar/Sidebar';

type HomeProps = InferGetStaticPropsType<typeof getStaticProps>;

const Home: React.FC<HomeProps> = ({ mangas }) => {
  return (
    <>
      <Head>
        <title>Ichirin no Hana Yuri - Mangas Yuri</title>
        <meta name='description' content='Pagina inicial do Ichirin no Hana Yuri' />
      </Head>
      <>
        <PageHeaderProvider>
          <Navbar />
          <Topbar />
          <Search />
          <Sidebar />
        </PageHeaderProvider>
        <>
          <FeatureCarrousel />
          <FeatureFinishes mangas={mangas.slice(0, 9)} />
          <LastMangaUpdates mangas={mangas.slice(9)} />
        </>
        <Footer />
      </>
    </>
  );
};

export const getStaticProps = async () => {
  let mangas: MangaData[] = new Array();
  try {
    const res = await fetch('http://localhost:3000/api/mangas');
    mangas = await res.json();
    mangas = mangas.slice(0, 45);
  } catch (ignored) {}

  return {
    props: {
      mangas,
    },
    revalidate: 30,
  };
};

export default Home;
