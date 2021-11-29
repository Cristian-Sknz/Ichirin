import styled, { keyframes } from 'styled-components';

export const Navbar = styled.nav`
  background-color: black;
  position: relative;
  z-index: var(--z-navbar);
`;

export const NavbarContainer = styled.div`
  display: flex;
  align-items: center;
  padding: 3rem 0;
  max-height: 117px;
  width: 85%;
  margin: 0 auto;
  justify-content: space-between;
  z-index: 1000;

  @media screen and (min-width: 968px) {
    max-width: var(--max-width);
  }
`;

export const NavbarLinks = styled.div`
  display: flex;
  align-items: center;

  & .logo {
    width: 232px;
  }

  @media screen and (max-width: 320px) {
    & .logo {
      content: url(/favicon.svg);
      width: 85px;
      height: 85px;
    }
  }
`;

export const NavbarList = styled.ul`
  display: none;
  margin: 0 3rem;

  @media screen and (min-width: 968px) {
    display: block;
  }
`;

export const NavbarItem = styled.li`
  display: inline-block;
  text-transform: uppercase;
  margin: 0.5rem 1rem;
  position: relative;

  & a {
    font-family: poppins, sans-serif;
    font-weight: 600;
    font-size: 0.9rem;
    color: white;
    text-decoration: none;
  }

  & a span {
    margin-left: 0.5rem;
  }

  & a::before {
    background: white;
    height: 2px;
    width: 0;
    opacity: 0.5;
    border-radius: 1rem;
    content: '';

    position: absolute;
    transform: translate(-50%, 0);
    left: 60%;
    bottom: -35%;

    transition: 300ms;
  }

  :hover a::before {
    width: 65px;
    transition: 300ms;
  }
`;

const rainbow = keyframes`
    0% {
        background-position: 0% 82%
    }
    50% {
        background-position: 100% 19%
    }
    100% {
        background-position: 0% 82%
    }
`;

export const SearchButton = styled.button`
  font-family: emoji;
  padding: 0.6rem;
  background: white;
  border: none;
  border-radius: 100%;
  color: black;
  transition: 0.4s;
  cursor: pointer;

  :hover {
    color: white;

    background: linear-gradient(124deg, #a20161, #fe9855, #cf619a, #a1044f);
    background-size: 1800% 1800%;

    animation: ${rainbow} 2s infinite;
  }
`;

export const InvertedSearchButton = styled(SearchButton)`
  color: white;
  background: linear-gradient(124deg, #a20161, #fe9855, #cf619a, #a1044f);
  background-size: 1800% 1800%;
  animation: ${rainbow} 2s infinite;

  :hover {
    color: black;
    background: white;
  }
`