import Head from 'next/head';
import Login from '../components/layouts/Login/Login';
import PageHeaderProvider from '../components/template/Contexts/header';
import Footer from '../components/template/Footer';
import Navbar from '../components/template/Navbar';
import Search from '../components/template/Search';
import Sidebar from '../components/template/Sidebar/Sidebar';
import Topbar from '../components/template/Topbar';

const LoginPage: React.FC = () => {
  return (
    <>
      <Head>
        <title>Entrar - Ichirin no Hana Yuri</title>
        <meta name='description' content='Entre com a sua conta Ichirin!' />
      </Head>
      <PageHeaderProvider>
        <Navbar />
        <Topbar />
        <Search />
        <Sidebar />
      </PageHeaderProvider>
      <Login/>
      <Footer/>
    </>
  );
};

export default LoginPage;
