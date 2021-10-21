import { TopbarItens } from '../../../lib/references';
import LinkListItem from '../../models/LinkListItem';
import SocialMedia from './models/SocialMedia';
import style from './Topbar.module.css';

export default function Topbar() {
  return (
    <div className={style.topbar}>
      <div className={style.topbar_body}>

        <div className={style.topbar_lists}>
          <ul className={style.social_medias}>
            <SocialMedia href='https://discord.gg/HgmMNPy' media='discord' />
            <SocialMedia href='https://fb.me/ichirinnohanayuri' media='facebook' />
            <SocialMedia href='https://m.me/ichirinnohanayuri' media='facebook-messenger' />
          </ul>

          <ul className={style.category_list}>
            {TopbarItens.map((item) => {
              return (<LinkListItem key={item.name} 
                   name={item.name}
                   href={item.link}/>
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
        
      </div>
    </div>
  );
}
