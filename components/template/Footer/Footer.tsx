import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import style from './Footer.module.css';

export default function Footer() {
    return (
    <footer className={style.footer}>
        <div className={style.footer_body}>
            <ul className={style.footer_links}>
                <li className={style.footer_link}>
                    <a href="./">Home</a>
                </li>

                <li className={style.footer_link}>
                    <a href="./">Quem Somos</a>
                </li>

                <li className={style.footer_link}>
                    <a href="./">FAQ</a>
                </li>

                <li className={style.footer_link}>
                    <a href="./">Política de Privacidade</a>
                </li>
            </ul>
            <div className={style.copyright}>
                <p>© 2021 Ichirin No Hana Yuri.</p>
                <p>Criado com <FontAwesomeIcon icon={['fas', 'heart']} color={'red'}/> por Cristian-SknZ</p>
            </div>
        </div>
    </footer>
    );
}