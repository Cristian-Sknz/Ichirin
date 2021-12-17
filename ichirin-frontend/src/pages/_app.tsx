import React from 'react';
import { AppProps } from 'next/app';
import NextNProgress from 'nextjs-progressbar';
import { ThemeProvider } from 'styled-components';

import Loading from '../components/template/Loading/Loading';
import GlobalStyle from '../styles/globals';
import IchirinDefaultTheme from '../styles/theme/default';

import AuthProvider, { AuthContext } from '../components/template/Contexts/AuthContext';

const MyApp = ({ Component, pageProps }: AppProps) => {
  return (
    <AuthProvider>
      <ThemeProvider theme={IchirinDefaultTheme}>
        <NextNProgress
          color='#a10160'
          startPosition={0.3}
          stopDelayMs={200}
          height={2}
          showOnShallow={true}
        />
        <AuthContext.Consumer>
          {(context) => (<Loading loading={context.loading} />)}
        </AuthContext.Consumer>
        <Component {...pageProps} />
        <GlobalStyle />
      </ThemeProvider>
    </AuthProvider>
  );
};

export default MyApp;
