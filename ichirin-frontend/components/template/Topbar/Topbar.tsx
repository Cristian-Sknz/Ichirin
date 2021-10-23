import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { useCallback, useRef } from 'react';
import { TopbarItens } from '../../../lib/references';
import LinkListItem from '../../models/LinkListItem';
import Sidebar, { SidebarHandles } from '../Sidebar/Sidebar';
import SocialMedia from './models/SocialMedia';
import style from './Topbar.module.css';

export default function Topbar() {
  const sidebarRef = useRef<SidebarHandles>(null);

  const handleSidebarClick = useCallback(() => {
    sidebarRef.current.toggleSidebar();
  }, [sidebarRef]);

  return (
    <>
    <div className={style.topbar}>
      <div className={style.topbar_body}>

        <div className={style.topbar_lists}>
          <ul className={style.social_medias}>
            <SocialMedia href='https://discord.gg/HgmMNPy' media='discord' />
            <SocialMedia href='https://fb.me/ichirinnohanayuri' media='facebook' />
            <SocialMedia href='https://m.me/ichirinnohanayuri' media='facebook-messenger' />
          </ul>

          <ul className={style.category_list}>
            {TopbarItens.map(({name, link}) => {
              return (<LinkListItem key={name}  name={name}href={link}/>
              );
            })}
          </ul>
        </div>

        <div className={style.user_authentication}>
          <div className={style.button}>
            <a href='# '>Entrar</a>
          </div>
          <div className={style.button}>
            <a href='# '>Cadastrar</a>
          </div>
        </div>
        <FontAwesomeIcon 
          className={style.sidebar_icon}
          icon={['fas', 'bars']} 
          onClick={handleSidebarClick}/>
      </div>
    </div>
    <Sidebar ref={sidebarRef}/>
    </>
  );
}
