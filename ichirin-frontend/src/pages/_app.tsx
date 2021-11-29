import React, { useEffect, useState } from 'react';
import {
  config as FontAwesomeConfiguration,
  library as IconLibrary,
} from '@fortawesome/fontawesome-svg-core';
import NextNProgress from 'nextjs-progressbar';
import { ThemeProvider } from 'styled-components';

import Loading from '../components/template/Loading/Loading';
import AppIcons from '../lib/IconsImports';
import GlobalStyle from '../styles/globals';
import IchirinDefaultTheme from '../styles/theme/default';

import '../styles/reset.css';
import '@fortawesome/fontawesome-svg-core/styles.css';
import 'react-responsive-carousel/lib/styles/carousel.min.css';
import { AppContext, AppProps } from 'next/app';

FontAwesomeConfiguration.autoAddCss = false;
AppIcons.forEach((icon) => IconLibrary.add(icon));

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
