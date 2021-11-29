import { createGlobalStyle } from 'styled-components';

const GlobalStyle = createGlobalStyle`
 :root {
    --max-width: 1224px;

    --z-navbar: 120;
    --z-topbar: 99;
    --z-searchbox: 100;
  }

  body {
    font-family: ${({theme}) => theme.fonts.primary};
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
    font-family: ${({theme}) => theme.fonts.primary};
  }

  a {
    color: ${({theme}) => theme.colors.gray};
    text-decoration: none;
    transition: color 250ms;
  }

  a:hover {
    color: ${({theme}) => theme.colors.pink};
    transition: color 250ms;
  }
`;

export default GlobalStyle;
