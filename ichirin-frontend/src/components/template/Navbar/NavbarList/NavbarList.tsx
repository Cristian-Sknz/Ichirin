import React from 'react';

import { IconProp } from '@fortawesome/fontawesome-svg-core';
import { FontAwesomeIcon as Icon } from '@fortawesome/react-fontawesome';
import AnchorLink from '../../../models/AnchorLink';

import { NavbarItem, NavbarList as StyledNavbarList } from '../style';

type NavbarListProps = {
  items: {
    name: string;
    icon: string[];
    href: string;
  }[];
};

const NavbarList: React.FC<NavbarListProps> = ({ items }) => {
  return (
    <StyledNavbarList>
      {items.map((item) => (
        <NavbarItem key={item.name}>
          <AnchorLink href={item.href}>
            <Icon icon={item.icon as IconProp} />
            <span>{item.name}</span>
          </AnchorLink>
        </NavbarItem>
      ))}
    </StyledNavbarList>
  );
};

export default NavbarList;
