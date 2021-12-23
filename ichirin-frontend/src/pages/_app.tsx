import React from 'react';
import { AppProps } from 'next/app';
import { ThemeProvider } from 'styled-components';

import GlobalStyle from '@ichirin/styles/globals';
import IchirinDefaultTheme from '@ichirin/styles/theme/default';

import AuthProvider from '@ichirin/contexts/auth';
import LoadingProvider from '@ichirin/contexts/loading';

const MyApp = ({ Component, pageProps }: AppProps) => {
  return (
    <LoadingProvider>
      <AuthProvider>
        <ThemeProvider theme={IchirinDefaultTheme}>
          <Component {...pageProps} />
          <GlobalStyle />
        </ThemeProvider>
      </AuthProvider>
    </LoadingProvider>
  );
};

export default MyApp;
