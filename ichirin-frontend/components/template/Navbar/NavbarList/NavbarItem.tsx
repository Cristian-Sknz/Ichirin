
import { IconProp } from '@fortawesome/fontawesome-svg-core';
import { FontAwesomeIcon as Icon } from '@fortawesome/react-fontawesome';
import AnchorLink from '../../../models/AnchorLink';

import style from '../Navbar.module.css';

export type NavbarItemProps = {
  name: string;  
  icon: string[];
  href: string;
}

function NavbarItem({icon , href, name } : NavbarItemProps) {
  return (
    <li className={style.navbar_item}>
      <AnchorLink href={href}>
        <Icon icon={icon as IconProp}/><span>{name}</span>
      </AnchorLink>
    </li>
  );
}

export default NavbarItem;