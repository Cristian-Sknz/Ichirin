import LinkListItem from "../Common/LinkListItem";
import SocialMedia from "./Fragments/SocialMedia";
import style from "./Topbar.module.css";


const category = [
    {name: 'Mangá', link: './'}, 
    {name: 'Manhwa', link: './'}, 
    {name: 'Manhua', link: './'}, 
    {name: 'Webtoon', link: './'}, 
    {name: 'Nsfw', link: './'}
];

export default function Topbar() {
    return (
    <div className={style.topbar}>
        <div className={style.topbar_lists}>

            <ul className={style.social_medias}>
                <SocialMedia href="./" media="discord"/>
                <SocialMedia href="./" media="facebook"/>
                <SocialMedia href="./" media="facebook-messenger"/>
            </ul>

            <ul className={style.category_list}>
                {category.map((item) => {
                    return <LinkListItem key={item.name} name={item.name} href={item.link}/>
                })}
            </ul>

        </div>

        <div className={style.user_authentication}>
            <div className={style.button}>
                <a href="# ">Entrar</a>
            </div>
            <div className={style.button}>
                <a href="# ">Cadastrar</a>
            </div>
        </div>
    </div>
    );
}