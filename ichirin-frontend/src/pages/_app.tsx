import React, { useEffect, useState } from 'react';
import NextNProgress from 'nextjs-progressbar';
import { ThemeProvider } from 'styled-components';

import Loading from '../components/template/Loading/Loading';
import GlobalStyle from '../styles/globals';
import IchirinDefaultTheme from '../styles/theme/default';

import { AppProps } from 'next/app';

const MyApp = ({ Component, pageProps } : AppProps) => {
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    setTimeout(() => setLoading(false), 1300);
  }, []);

  return (
    <ThemeProvider theme={IchirinDefaultTheme}>
      <NextNProgress
        color='#a10160'
        startPosition={0.3}
        stopDelayMs={200}
        height={2}
        showOnShallow={true}
      />

      <Loading loading={loading} />
      <Component {...pageProps} />
      <GlobalStyle />
    </ThemeProvider>
  );
};

export default MyApp;
