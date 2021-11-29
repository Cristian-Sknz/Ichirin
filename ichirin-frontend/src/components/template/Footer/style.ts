import styled from 'styled-components';

export const Footer = styled.footer`
  box-shadow: 0px -2px 2px 0px #c5c5c5;
  font-family: 'Poppins', sans-serif;
`;

export const FooterContainer = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 1rem 0;
  transition: 0.4s;

  @media screen and (min-width: 475px) {
    padding: 3rem 0;
    transition: 0.4s;
  }
`;

export const FooterLinks = styled.ul``;

export const FooterLink = styled.li`
  display: block;
  text-align: center;
  padding: 1rem;

  & a {
    text-decoration: none;
    font-size: 0.875rem;
    text-transform: uppercase;
    font-weight: 400;
  }

  @media screen and (min-width: 475px) {
    display: inline-block;
  }
`;

export const Copyright = styled.div`
  font-weight: 400;
  font-size: 0.7rem;
  text-align: center;
  color: rgb(105, 105, 105);
`;
