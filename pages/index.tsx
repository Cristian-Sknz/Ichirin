import { InferGetStaticPropsType } from 'next';
import Head from 'next/head';

import FeatureCarrousel from '../components/layouts/Home/FeatureCarrousel';
import FeaturedCompleted from '../components/layouts/Home/FeaturedCompleted';
import LastMangaUpdates from '../components/layouts/Home/LastMangaUpdates';

import Navbar from '../components/template/Navbar';
import Topbar from '../components/template/Topbar';
import Footer from '../components/template/Footer';
import MangaData from '../lib/types';

export default function Home({mangas} : InferGetStaticPropsType<typeof getStaticProps>) {
  return (
    <>
      <Head>
        <title>Ichirin no Hana Yuri</title>
        <meta name='description' content='Pagina inicial do Ichirin no Hana Yuri' />
      </Head>
      <>
        <Navbar/>
        <Topbar/>
        <>
          <FeatureCarrousel/>
          <FeaturedCompleted mangas={mangas.slice(0, 9)}/>
          <LastMangaUpdates mangas={mangas.slice(9)}/>
        </>
        <Footer/>
      </>
    </>
  );
}

export const getStaticProps = async () => {
  let mangas: MangaData[] = []
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
  }
}
