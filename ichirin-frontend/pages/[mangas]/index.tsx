import { GetStaticPaths, GetStaticProps } from 'next';
import Head from 'next/head';
import MangaLists from '../../components/layouts/MangaLists/MangaLists';
import Navbar from '../../components/template/Navbar';
import Topbar from '../../components/template/Topbar';

function MangaType(props) {
  return (
    <>
      <Head>
        <title>Mangas - Ichirin no Hana Yuri</title>
        <meta
          name='description'
          content='Pagina inicial do Ichirin no Hana Yuri'
        />
      </Head>
      <>
      <Navbar/>
      <Topbar/>
      <MangaLists/>
      </>
    </>
  );
}

export const getStaticProps: GetStaticProps = async (context) => {
  return { props: { value: null } };
};

export const getStaticPaths: GetStaticPaths = async () => {
  const paths = ['mangas', 'manhuas', 'manhwas', 'webtoon', 'nsfw'];
  return {
    paths: paths.map((path) => ({ params: { mangas: path } })),
    fallback: false,
  };
};


export default MangaType;