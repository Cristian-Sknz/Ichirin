import AnchorLink from "../../../models/AnchorLink";
import style from '../Sidebar.module.css';

type DropdownItemProps = {
    children: JSX.Element | JSX.Element[] | string;
    href: string;
}

export default function DropdownItem({children, href} : DropdownItemProps) {
    return (
        <li className={style.dropdown_item}>
            <AnchorLink href={href}>
                {children}
            </AnchorLink>
        </li>
    )
}