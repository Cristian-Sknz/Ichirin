import styled from 'styled-components';
import AnchorLink from '@models/AnchorLink';

export const StyledSidebar = styled.div`
  display: flex;
  flex-direction: column;
  position: fixed;
  align-items: center;

  width: 300px;
  height: 100%;
  z-index: 5000;
  top: 0;

  background: #000000f2;
  font-family: 'Poppins';
  padding: 7rem 0;
  overflow-x: hidden;
  overflow-y: auto;

  max-width: 0;
  transition: 500ms ease-out;

  &.active {
    max-width: 300px;
    transition: 500ms ease-in;
  }

  ::-webkit-scrollbar {
    width: 0.5rem;
  }

  ::-webkit-scrollbar-track {
    background: black;
  }

  ::-webkit-scrollbar-thumb {
    background-color: white;
    border: 3px solid rgba(255, 255, 255, 0.404);
    border-radius: 20px;
  }
  @media screen and (max-width: 425px) {
    width: 100%;
  }
`;

export const Sidebar = styled(StyledSidebar)`
  & .sidebar_close {
    color: white;
    position: absolute;
    top: 10%;
    right: 10%;
    font-size: 1.6rem;
    cursor: pointer;
    transition: 300ms;
    :hover {
      transform: scale(1.2);
      transition: 300ms;
    }
  }

  & .logo {
    padding: 1rem !important;
  }
`;

export const LoginContainer = styled.div`
  align-items: center;
  display: flex;
`;

export const Button = styled(AnchorLink)`
  background: #eb3349;
  display: inline-block;
  padding: ${(props) =>
    props.className == 'login' ? '.6rem 1.8rem' : '.6rem .8rem'};
  border: 2px solid white;
  border-radius: 2rem;
  margin: 0.2rem;
  transition: 300ms;
  cursor: pointer;

  & {
    color: white;
    text-decoration: none;
    font-family: 'Poppins';
    font-weight: 500;
    transition: 300ms;
  }

  :hover {
    background-color: transparent;
    border-color: #eb3349;
    color: #eb3349;
    transition: 300ms;
  }
`;

export const DropdownList = styled.ul`
  display: flex;
  flex-direction: column;
  align-items: flex-start;

  width: 180px;
  margin: 0 auto;

  text-align: center;
  max-height: 0;
  overflow: hidden;
  transition: 0.3s;
`;

export const DropdownItem = styled.li`
  display: inline-block;
  text-transform: uppercase;
  margin: 0.5rem 1rem;
  position: relative;
  & a {
    color: white;
  }
`;

export const Dropdown = styled.div`
  & h2 {
    font-size: 1.6rem;
    font-weight: 500;
    margin: 1rem 0;
    position: relative;
    color: white;
    text-align: center;
  }

  & .dropdown_icon {
    top: -0.2rem;
    left: -1.7rem;
    position: absolute;
    font-size: 1rem;
    vertical-align: middle;
    margin: 0.5rem;
    transform: rotate(90deg);
    transition: transform 0.5s;
  }

  &.active {
    & .dropdown_icon {
      transform: rotate(180deg);
      transition: transform 0.5s;
    }
    & ${DropdownList} {
      max-height: 300px;
      transition: 0.8s;
    }
  }
`;
