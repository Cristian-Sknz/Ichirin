import { createGlobalStyle, css } from 'styled-components';
import * as Core from '@fortawesome/fontawesome-svg-core';
import AppIcons from '../lib/IconsImports';
import ResetCSS from './reset';

const ReactCarrouselCSS = process(require('react-responsive-carousel/lib/styles/carousel.min.css'));
const FontAweasomeCSS = process(require('@fortawesome/fontawesome-svg-core/styles.css'));

function process(require: any) {
  return css`${require}`;
}

const GlobalStyle = createGlobalStyle`
  ${ReactCarrouselCSS}
  ${FontAweasomeCSS}
  ${ResetCSS}
 
 :root {
    --max-width: 1224px;

    --z-navbar: 120;
    --z-topbar: 99;
    --z-searchbox: 100;
  }

  body {
    font-family: ${({ theme }) => theme.fonts.primary};
  }

  body::-webkit-scrollbar {
    width: .6rem;
  }

  body::-webkit-scrollbar-track {
    background: black
  }
  
  body::-webkit-scrollbar-thumb {
    background-color: white;
    border: 3px solid rgba(255, 255, 255, 0.404);
    border-radius: 20px;
  }

  h1, h2, h3, h4, p, button {
    font-family: ${({ theme }) => theme.fonts.primary};
  }

  a {
    color: ${({ theme }) => theme.colors.gray};
    text-decoration: none;
    transition: color 250ms;
  }

  a:hover {
    color: ${({ theme }) => theme.colors.pink};
    transition: color 250ms;
  }
`;

Core.config.autoAddCss = false;
AppIcons.forEach((icon) => Core.library.add(icon));

export default GlobalStyle;
