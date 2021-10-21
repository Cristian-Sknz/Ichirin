
import { IconProp } from '@fortawesome/fontawesome-svg-core';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import AnchorLink from '../../../models/ALink';

export type NavbarItemProps = {
    href: string;
    name: string;
    icon: string[];
}

export default function NavbarItem({icon , href, name } : NavbarItemProps) {
  return (
    <li className="navbar-item">
      <AnchorLink href={href}>
        <FontAwesomeIcon icon={icon as IconProp}/><span>{name}</span>
      </AnchorLink>
    </li>
  );
}
