import React from 'react';

import { NavbarList as StyledNavbarList } from '../style';
import NavbarItem, { NavbarItemProps } from './NavbarItem';

type NavbarListProps = {
  items: NavbarItemProps[];
};

const NavbarList: React.FC<NavbarListProps> = ({ items }) => {
  return (
    <StyledNavbarList>
      {items.map((item) => (
        <NavbarItem key={item.name} {...item}/>
      ))}
    </StyledNavbarList>
  );
};

export default NavbarList;
