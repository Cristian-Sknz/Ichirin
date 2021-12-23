import React, { useContext } from 'react';
import { FontAwesomeIcon as Icon } from '@fortawesome/react-fontawesome';
import classNames from 'classnames';
import Image from 'next/image';

import { NavbarItens, TopbarItens } from '@ichirin/lib/references';
import { PageHeaderContext } from '@ichirin/contexts/header';

import AnchorLink from '@models/AnchorLink';
import NavbarItem from '../Navbar/NavbarList/NavbarItem';
import DropdownItem from './Dropdown/DropdownItem';
import SidebarDropdown from './Dropdown/SidebarDropdown';
import { Button, LoginContainer, Sidebar as StyledSidebar } from './style';


const Sidebar: React.FC = ({}) => {
  const { sidebar, toggleSidebar } = useContext(PageHeaderContext);
  return (
    <StyledSidebar className={classNames({ active: sidebar })}>
      <Icon
        className={'sidebar_close'}
        icon={['fas', 'times']}
        onClick={toggleSidebar}
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
        <Button className={'login'} href={'/auth/signin'}>Entrar</Button>
        <Button href={'/auth/signup'}>Cadastrar</Button>
      </LoginContainer>

      <SidebarDropdown title={'Navegação'} defaultValue>
        {NavbarItens.map((item) => (
          <NavbarItem key={item.name} {...item}/>
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

export default Sidebar;
