import Head from 'next/head';

import FeatureCarrousel from '../components/layouts/Home/FeatureCarrousel';
import FeaturedCompleted from '../components/layouts/Home/FeaturedCompleted';
import LastMangaUpdates from '../components/layouts/Home/LastMangaUpdates';
import Footer from '../components/template/Footer';

import Navbar from '../components/template/Navbar';
import Topbar from '../components/template/Topbar';

export default function Home() {
  return (
    <>
      <Head>
        <title>Ichirin no Hana Yuri</title>
        <meta name='description' content='Pagina inicial do Ichirin no Hana Yuri' />
        <link rel='icon' href='/favicon.ico' />
      </Head>
      <>
        <Navbar/>
        <Topbar/>

        <FeatureCarrousel/>
        <FeaturedCompleted/>
        <LastMangaUpdates/>

        <Footer/>
      </>
    </>
  );
}
