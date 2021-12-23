import React from 'react';
import Head from 'next/head';

import Register from '@layouts/Login/Register';
import Footer from '@template/Footer';
import Navbar from '@template/Navbar';
import Search from '@template/Search';
import Sidebar from '@template/Sidebar/Sidebar';
import Topbar from '@template/Topbar';

import PageHeaderProvider from '@ichirin/contexts/header';

const SignupPage: React.FC = () => {
  return (
    <>
      <Head>
        <title>Registrar - Ichirin no Hana Yuri</title>
        <meta name='description' content='Crie a sua conta no Ichirin!' />
      </Head>
      <PageHeaderProvider>
        <Navbar />
        <Topbar />
        <Search />
        <Sidebar />
      </PageHeaderProvider>
      <Register />
      <Footer/>
    </>
  );
};

export default SignupPage;
