import { FontAwesomeIcon as Icon } from '@fortawesome/react-fontawesome';
import React, { useCallback, useRef } from 'react';

import { NavbarItens } from '../../../lib/references';
import AnchorLink from '../../models/AnchorLink';
import Search, { SearchHandles } from '../Search';
import NavbarList from './NavbarList/NavbarList';
import { InvertedSearchButton, NavbarContainer, NavbarLinks, Navbar as StyledNavbar } from './style';

const Navbar: React.FC = () => {
  const searchRef = useRef<SearchHandles>(null);

  const handleSearchButton = useCallback(() => {
    searchRef.current.toggleModal();
  }, []);

  return (
    <>
      <StyledNavbar>
        <NavbarContainer>

          <NavbarLinks>
            <AnchorLink href={'/'}>
              <img src='/logo.svg' className={'logo'} alt={'Ichirin Logo'} />
            </AnchorLink>
            <NavbarList items={NavbarItens} />
          </NavbarLinks>

          <InvertedSearchButton onClick={handleSearchButton}>
            <Icon icon={['fas', 'search']} />
          </InvertedSearchButton>

        </NavbarContainer>
      </StyledNavbar>
      <Search ref={searchRef} />
    </>
  );
};

export default Navbar;
