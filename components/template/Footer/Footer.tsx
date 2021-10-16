import ALink from '../../models/ALink';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import style from './Footer.module.css';

export default function Footer() {
    return (
    <footer className={style.footer}>
        <div className={style.footer_body}>
            <ul className={style.footer_links}>
                <li className={style.footer_link}>
                    <ALink href={'/'}>Home</ALink>
                </li>
                <li className={style.footer_link}>
                    <ALink href={'/sobre'}>Quem Somos</ALink>
                </li>
                <li className={style.footer_link}>
                    <ALink href={'/faq'}>FAQ</ALink>
                </li>
                <li className={style.footer_link}>
                    <ALink href={'/privacy'}>Política de Privacidade</ALink>
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