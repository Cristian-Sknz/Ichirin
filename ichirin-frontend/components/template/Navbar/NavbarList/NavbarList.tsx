import React from 'react';
import NavbarItem, { NavbarItemProps } from './NavbarItem';
import style from '../Navbar.module.css';

type NavbarListProps = {
  items: NavbarItemProps[];
};

export default function NavbarList({ items }: NavbarListProps) {
  return (
    <ul className={style.navbar_list}>
      {items.map((item) => {
        return (
          <NavbarItem
            name={item.name}
            href={item.href}
            icon={item.icon}
            key={item.name}
          />
        );
      })}
    </ul>
  );
}
