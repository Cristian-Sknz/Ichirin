import { IconProp } from '@fortawesome/fontawesome-svg-core';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

type NavbarItemProps = {
    href: string;
    name: string;
    icon: string[];
}

export default function NavbarItem({icon , href, name } : NavbarItemProps) {
  return (
    <li className="navbar-item">
      <a href={href}>
          <FontAwesomeIcon icon={icon as IconProp}/><span>{name}</span>
      </a>
    </li>
  );
}
