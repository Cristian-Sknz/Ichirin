import { FontAwesomeIcon as Icon } from '@fortawesome/react-fontawesome';
import Image from 'next/image';
import React, { forwardRef, useImperativeHandle, useState } from 'react';

import { NavbarItens, TopbarItens } from '../../../lib/references';
import AnchorLink from '../../models/AnchorLink';
import DropdownItem from './Dropdown/DropdownItem';
import SidebarDropdown from './Dropdown/SidebarDropdown';
import { Button, LoginContainer, Sidebar as StyledSidebar } from './style';
import { NavbarItem } from '../Navbar/style';
import { IconProp } from '@fortawesome/fontawesome-svg-core';

export type SidebarHandles = {
  toggleSidebar: () => void;
};

const Sidebar = ({}, ref: React.RefObject<SidebarHandles>) => {
  const [open, setOpen] = useState<boolean>(false);
  useImperativeHandle(ref, () => ({ toggleSidebar: () => setOpen(!open) }));

  return (
    <StyledSidebar className={open ? 'active' : ''}>
      <Icon
        className={'sidebar_close'}
        icon={['fas', 'times']}
        onClick={() => setOpen(false)}
      />
      <AnchorLink href={'/'}>
        <Image
          src='/logo.svg'
          className={'logo'}
          width={250}
          height={72}
          alt={'Ichirin Logo'}
        />
      </AnchorLink>

      <LoginContainer>
        <Button className={'login'}>Entrar</Button>
        <Button>Cadastrar</Button>
      </LoginContainer>

      <SidebarDropdown title={'Navegação'} defaultValue>
        {NavbarItens.map((item) => (
          <NavbarItem key={item.name}>
            <AnchorLink href={item.href}>
              <Icon icon={item.icon as IconProp} />
              <span>{item.name}</span>
            </AnchorLink>
          </NavbarItem>
        ))}
      </SidebarDropdown>

      <SidebarDropdown title={'Listas de Mangas'}>
        {TopbarItens.map(({ name, link }) => (
          <DropdownItem key={name} href={link}>
            {name}
          </DropdownItem>
        ))}
      </SidebarDropdown>
    </StyledSidebar>
  );
};

export default forwardRef(Sidebar);
