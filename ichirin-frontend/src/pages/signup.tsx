import Head from 'next/head';
import React from 'react';
import Register from '../components/layouts/Login/Register';
import PageHeaderProvider from '../components/template/Contexts/header';
import Footer from '../components/template/Footer';
import Navbar from '../components/template/Navbar';
import Search from '../components/template/Search';
import Sidebar from '../components/template/Sidebar/Sidebar';
import Topbar from '../components/template/Topbar';

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
