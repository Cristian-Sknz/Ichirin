
import { IconProp } from '@fortawesome/fontawesome-svg-core';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import AnchorLink from '../../../models/AnchorLink';

import style from '../Navbar.module.css';

export type NavbarItemProps = {
  name: string;  
  icon: string[];
  href: string;
}

export default function NavbarItem({icon , href, name } : NavbarItemProps) {
  return (
    <li className={style.navbar_item}>
      <AnchorLink href={href}>
        <FontAwesomeIcon icon={icon as IconProp}/><span>{name}</span>
      </AnchorLink>
    </li>
  );
}
