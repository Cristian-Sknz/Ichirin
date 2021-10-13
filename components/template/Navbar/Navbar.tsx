import NavbarItem from './NavbarItem';
import style from './Navbar.module.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

const items = [
  {
    name: 'Home',
    icon: ['fas', 'home'],
    href: './',
  },
  {
    name: 'Projetos',
    icon: ['fas', 'list-alt'],
    href: './projetos',
  },
  {
    name: 'Procurar',
    icon: ['fas', 'search'],
    href: './search',
  },
  {
    name: 'Top 12',
    icon: ['fas', 'star'],
    href: './top',
  },
  {
    name: 'Contato',
    icon: ['fas', 'envelope-open-text'],
    href: './contato',
  },
];

export default function Navbar() {
  return (
    <nav className={style.navbar}>
      <div className={style.navbar_body}>
        <div className={style.navbar_navigation}>
          <a href='# '>
            <img src='./logo.svg' className={style.logo} />
          </a>

          <ul className={style.navbar_list}>
            {items.map((item) => {
              return (
                <NavbarItem
                  name={item.name}
                  href={item.href}
                  icon={item.icon}
                  key={item.name}
                />);
            })}
          </ul>
        </div>

        <div className={style.navbar_mobile}>
          <a className={style.navbar_search} href='# '>
            <FontAwesomeIcon icon={['fas', 'search']} />
          </a>

          {/*<button className={style.mobile_button}/>*/}
        </div>
      </div>
    </nav>
  );
}
