import styled from 'styled-components';
import Image from 'next/image';
import AnchorLink from '../../models/AnchorLink';
import ListItem from '../../models/LinkListItem';

export const Topbar = styled.div`
  position: sticky;
  background-color: white;
  top: 0;
  box-shadow: 0px 0px 2px 0px black;
  z-index: var(--z-topbar);
`;

export const TopbarBody = styled.div`
  display: flex;
  flex-direction: row;
  align-items: center;

  justify-content: space-between;
  width: 95%;
  margin: 0 auto;
  padding: 0.8rem 0;

  & .menu-btn {
    font-size: 1.2rem;
    margin: 0 1rem;
    display: block;
    cursor: pointer;
  }

  @media screen and (min-width: 768px) {
    justify-content: center;
  }

  @media screen and (min-width: 968px) {
    justify-content: space-between;
    width: 85%;
    max-width: var(--max-width);
    & .menu-btn {
      display: none;
    }
  }
`;

export const TopbarLists = styled.div`
  display: flex;
  flex-direction: row;
  align-items: center;
`;

export const SocialMedias = styled.div`
  & li {
    display: inline-block;
    margin: 0 0.8rem;
  }

  & li a {
    color: ${({ theme }) => theme.colors.secondary};
    background: transparent;
    font-size: 1.8rem;
    transition: 128ms;
  }
`;

export const SocialMedia = styled.li`
  display: inline-block;
  margin: 0 0.8rem;
`;

export const SocialMediaLink = styled.a`
  background: transparent;
  color: ${({ theme }) => theme.colors.secondary};
  font-size: 1.8rem;
  transition: 128ms;

  :hover {
    color: #000;
    transition: 128ms;
  }
`;

export const Categories = styled.ul`
  display: none;

  & li {
    display: inline-block;
    margin: 0 0.3rem;
  }

  & li a {
    color: ${({ theme }) => theme.colors.secondary};
    font-family: poppins, sans-serif;
    text-decoration: none;
    text-transform: uppercase;
    padding: 1rem;

    font-size: 0.87rem;
    font-weight: 600;
    transition: color 128ms;
  }

  & li a:hover {
    color: #141414;
    transition: color 128ms;
  }
  @media screen and (min-width: 768px) {
    display: block;
  }
`;

export const LoginContainer = styled.div`
  @media screen and (min-width: 968px) {
    position: relative;
    display: flex;
    align-items: center;
  }
  display: none;
`;

export const LoggedUsername = styled.p`
  cursor: default;
  font-size: 0.9rem;
  font-weight: 300;
  margin: 0 0.6rem;
`;

export const UserAvatar = styled(Image)`
  border: 2px solid #999 !important;
  border-radius: 50%;
  cursor: pointer;
`;

export const Dropdown = styled.div`
  position: absolute;
  width: 158px;
  background-color: white;
  top: 100%;
  right: 0;
  border-bottom: 0.3rem solid black;
  padding: 0.3rem;

  & {
    opacity: 0;
    visibility: hidden;
    transition: 0.5s;
    &.dropdown,
    :hover {
      opacity: 1;
      visibility: visible;
      transition: 0.5s;
    }
  }
`;

export const DropdownList = styled.ul`
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  padding: 0 0.5rem;

  transition: 0.3s;
  li {
    margin: 0.2rem 0;
  }
`;

export const DropdownItem = ListItem;

export const Button = styled(AnchorLink)`
  display: inline-block;
  padding: 0.5rem 0.8rem;
  border: 2px solid #666666;
  border-radius: 2rem;
  margin: 0.2rem;
  transition: 300ms;
  cursor: pointer;

  & {
    color: #666666;
    text-decoration: none;
    font-family: 'Poppins';
    font-weight: 500;
    transition: 300ms;
  }

  :hover {
    background-color: black;
    border-color: black;
    color: white;
    transition: 300ms;
  }
`;
