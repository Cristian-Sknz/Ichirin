import { useCallback, useRef } from 'react';

import AnchorLink from '../../models/AnchorLink';
import NavbarList from './NavbarList/NavbarList';
import Searchbox, { SearchBoxHandles } from '../Search';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { NavbarItens } from '../../../lib/references';

import style from './Navbar.module.css';

export default function Navbar() {
  const searchRef = useRef<SearchBoxHandles>(null);
  const toggle = useRef(false);

  const handleSearchButton = useCallback(() => {
    searchRef.current.toggleModal();
  },[])

  return (
    <>
      <nav className={style.navbar}>
        <div className={style.navbar_body}>
          <div className={style.navbar_navigation}>
            <AnchorLink href={'/'}>
              <img src='/logo.svg' className={style.logo} />
            </AnchorLink>
            <NavbarList items={NavbarItens} />
          </div>

          <div className={style.navbar_mobile}>
            <a className={style.navbar_search} href='# ' onClick={handleSearchButton}>
              <FontAwesomeIcon icon={['fas', 'search']} />
            </a>
          </div>
        </div>
      </nav>
      <Searchbox ref={searchRef}/>
    </>
  );
}
