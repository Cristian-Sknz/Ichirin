import React from 'react';
import Head from 'next/head';

import Login from '@layouts/Login/Login';
import Footer from '@template/Footer';
import Navbar from '@template/Navbar';
import Search from '@template/Search';
import Sidebar from '@template/Sidebar/Sidebar';
import Topbar from '@template/Topbar';

import PageHeaderProvider from '@ichirin/contexts/header';

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
