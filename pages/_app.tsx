import '../styles/globals.css'
import '../styles/reset.css'
import '@fortawesome/fontawesome-svg-core/styles.css';
import '../styles/slick.css'

import { library, config } from '@fortawesome/fontawesome-svg-core';
import { faArrowRight, faEnvelopeOpenText, faHeart, faHome, faListAlt, faSearch, faStar, faStarHalf } from '@fortawesome/free-solid-svg-icons';
import { faDiscord, faFacebook, faFacebookMessenger, faInstagram} from '@fortawesome/free-brands-svg-icons';
import { faStar as farStar } from '@fortawesome/free-regular-svg-icons';

config.autoAddCss = false; /* eslint-disable import/first */
library.add(faHome, faListAlt, faSearch, faStar, faEnvelopeOpenText, farStar, faStarHalf, faArrowRight);
library.add(faFacebook, faFacebook, faInstagram, faDiscord, faFacebookMessenger);
library.add(faHeart);

function MyApp({ Component, pageProps }) {
  return <Component {...pageProps} />
}

export default MyApp
