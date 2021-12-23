import React from 'react';
import { IconProp } from '@fortawesome/fontawesome-svg-core';
import { FontAwesomeIcon as Icon } from '@fortawesome/react-fontawesome';

import AnchorLink from '@models/AnchorLink';
import { NavbarItem as StyledNavbarItem } from '../style';

export type NavbarItemProps = {
  name: string;
  icon: string[] | IconProp;
  href: string;
};

const NavbarItem: React.FC<NavbarItemProps> = (props) => {
  return (
    <StyledNavbarItem key={props.name}>
      <AnchorLink href={props.href}>
        <Icon icon={props.icon as IconProp} />
        <span>{props.name}</span>
      </AnchorLink>
    </StyledNavbarItem>
  );
};

export default NavbarItem;
