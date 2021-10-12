import Head from 'next/head';

import FeatureCarrousel from '../components/Home/FeatureCarrousel';
import FeaturedCompleted from '../components/Home/FeaturedCompleted';
import Navbar from '../components/UI/Navbar';
import Topbar from '../components/UI/Topbar';

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
      </>
    </>
  );
}
