import React from 'react';
import { library, config } from '@fortawesome/fontawesome-svg-core';

import AppIcons from '../lib/IconsImports';

import '@fortawesome/fontawesome-svg-core/styles.css';
import '../styles/globals.css'
import '../styles/reset.css'
import '../styles/slick.css'

config.autoAddCss = false; /* eslint-disable import/first */


for (var icon of AppIcons) {
  library.add(icon);
}

function MyApp({ Component, pageProps }) {
  return <Component {...pageProps} />
}

export default MyApp
