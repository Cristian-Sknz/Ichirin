import AnchorLink from '../../models/AnchorLink';
import { FontAwesomeIcon as Icon} from '@fortawesome/react-fontawesome';
import style from './Footer.module.css';

function Footer() {
    return (
    <footer className={style.footer}>
        <div className={style.footer_body}>
            <ul className={style.footer_links}>
                <li className={style.footer_link}>
                    <AnchorLink href={'/'}>Home</AnchorLink>
                </li>
                <li className={style.footer_link}>
                    <AnchorLink href={'/sobre'}>Quem Somos</AnchorLink>
                </li>
                <li className={style.footer_link}>
                    <AnchorLink href={'/faq'}>FAQ</AnchorLink>
                </li>
                <li className={style.footer_link}>
                    <AnchorLink href={'/privacy'}>Política de Privacidade</AnchorLink>
                </li>
            </ul>
            <div className={style.copyright}>
                <p>© 2021 Ichirin No Hana Yuri.</p>
                <p>Criado com <Icon icon={['fas', 'heart']} color={'red'}/> por Cristian-SknZ</p>
            </div>
        </div>
    </footer>
    );
}

export default Footer;