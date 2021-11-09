import React, { forwardRef, useImperativeHandle, useState } from 'react';
import Image from 'next/image'
import { FontAwesomeIcon as Icon } from '@fortawesome/react-fontawesome';

import NavbarItem from '../Navbar/NavbarList/NavbarItem';
import DropdownItem from './Dropdown/DropdownItem';
import SidebarDropdown from './Dropdown/SidebarDropdown';

import AnchorLink from '../../models/AnchorLink';
import { NavbarItens, TopbarItens } from '../../../lib/references';
import style from './Sidebar.module.css';

export type SidebarHandles = {
  toggleSidebar: () => void;
}

function Sidebar({}, ref: React.RefObject<SidebarHandles>) {
  const [open, setOpen] = useState<boolean>(false);
  useImperativeHandle(ref, () => ({ toggleSidebar: () => setOpen(!open) }));

  return (
    <div className={`${style.sidebar} ${(open) ? style.active : ''}`}>
      <Icon className={style.sidebar_close} 
        icon={['fas', 'times']} 
        onClick={() => setOpen(false)}
      />
      <AnchorLink href={'/'}>
        <Image 
          src='/logo.svg' 
          className={style.logo} 
          width={250} 
          height={72}
          alt={'Ichirin Logo'}
        />
      </AnchorLink>

      <div className={style.user_authentication}>
        <div className={`${style.button} ${style.login}`}>
          <a href='# '>Entrar</a>
        </div>
        <div className={style.button}>
          <a href='# '>Cadastrar</a>
        </div>
      </div>

      <SidebarDropdown title={'Navegação'} defaultValue>
        {NavbarItens.map(({ name, href, icon }, index) => {
          return <NavbarItem key={index} name={name} icon={icon} href={href} />;
        })}
      </SidebarDropdown>

      <SidebarDropdown title={'Listas de Mangas'}>
        {TopbarItens.map(({ name, link }) => {
          return (
            <DropdownItem key={name} href={link}>
              {name}
            </DropdownItem>
          );
        })}
      </SidebarDropdown>
    </div>
  );
}

export default forwardRef(Sidebar);
