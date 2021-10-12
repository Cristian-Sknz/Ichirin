import '../styles/globals.css'
import '../styles/reset.css'
import '@fortawesome/fontawesome-svg-core/styles.css';

import { library, config } from '@fortawesome/fontawesome-svg-core';
import { faEnvelopeOpenText, faHome, faListAlt, faSearch, faStar } from '@fortawesome/free-solid-svg-icons';
import { faDiscord, faFacebook, faFacebookMessenger, faInstagram} from '@fortawesome/free-brands-svg-icons';

config.autoAddCss = false; /* eslint-disable import/first */
library.add(faHome, faListAlt, faSearch, faStar, faEnvelopeOpenText)
library.add(faFacebook, faFacebook, faInstagram, faDiscord, faFacebookMessenger)

function MyApp({ Component, pageProps }) {
  return <Component {...pageProps} />
}

export default MyApp
