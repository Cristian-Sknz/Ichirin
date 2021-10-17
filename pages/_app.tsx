import React, { useEffect, useState } from 'react';
import { library, config } from '@fortawesome/fontawesome-svg-core';
import NextNProgress from 'nextjs-progressbar';
import Head from 'next/head'

import AppIcons from '../lib/IconsImports';
import Loading from '../components/template/Loading/Loading';

import '@fortawesome/fontawesome-svg-core/styles.css';
import '../styles/globals.css';
import '../styles/reset.css';
import '../styles/slick.css';

config.autoAddCss = false; /* eslint-disable import/first */
AppIcons.forEach((icon) => library.add(icon));

function MyApp({ Component, pageProps }) {
  const [loading, setLoading] = useState(true);

  // Loading inicial do Ichirin
  useEffect(() => {
    setTimeout(() => setLoading(false), 1300);
  }, []);

  return (
    <>
    <Head>
      <link rel='icon' href='/favicon.svg' />
    </Head>

      <NextNProgress
        color='#a10160'
        startPosition={0.3}
        stopDelayMs={200}
        height={2}
        showOnShallow={true}
      />
      
      <Loading loading={loading} />
      <Component {...pageProps} />
    </>
  );
}

export default MyApp;
