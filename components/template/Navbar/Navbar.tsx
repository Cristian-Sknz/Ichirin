import AnchorLink from '../../models/ALink';

import style from './Navbar.module.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import Searchbox, { SearchBoxHandles } from '../Search/Searchbox';
import NavbarList from './NavbarList/NavbarList';
import { useCallback, useRef } from 'react';

const items = [
  {
    name: 'Home',
    icon: ['fas', 'home'],
    href: '/',
  },
  {
    name: 'Projetos',
    icon: ['fas', 'list-alt'],
    href: '/projetos',
  },
  {
    name: 'Procurar',
    icon: ['fas', 'search'],
    href: '/search',
  },
  {
    name: 'Top 12',
    icon: ['fas', 'star'],
    href: '/top',
  },
  {
    name: 'Contato',
    icon: ['fas', 'envelope-open-text'],
    href: '/contato',
  },
];

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
            <NavbarList items={items} />
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
