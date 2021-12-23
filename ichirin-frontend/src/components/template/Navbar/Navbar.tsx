import React, { useContext } from 'react';
import { FontAwesomeIcon as Icon } from '@fortawesome/react-fontawesome';

import { NavbarItens } from '@ichirin/lib/references';
import { PageHeaderContext } from '@ichirin/contexts/header';

import AnchorLink from '@models/AnchorLink';
import NavbarList from './NavbarList/NavbarList';
import {
  InvertedSearchButton,
  NavbarContainer,
  NavbarLinks,
  Navbar as StyledNavbar,
} from './style';

const Navbar: React.FC = () => {
  const { toggleSearch } = useContext(PageHeaderContext);

  return (
    <StyledNavbar>
      <NavbarContainer>
        <NavbarLinks>
          <AnchorLink href={'/'}>
            <img src='/logo.svg' className={'logo'} alt={'Ichirin Logo'} />
          </AnchorLink>
          <NavbarList items={NavbarItens} />
        </NavbarLinks>

        <InvertedSearchButton onClick={toggleSearch}>
          <Icon icon={['fas', 'search']} />
        </InvertedSearchButton>
      </NavbarContainer>
    </StyledNavbar>
  );
};

export default Navbar;
