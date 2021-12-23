import React from 'react';
import type { GetServerSideProps } from 'next';
import { destroyCookie } from 'nookies';

const LogoutPage: React.FC = () => {
  return <></>
}

export const getServerSideProps: GetServerSideProps = async (ctx) => {
  destroyCookie(ctx, 'token');
  return {
    redirect: {
      destination: '/auth/signin',
      permanent: false,
    }
  }
}

export default LogoutPage;