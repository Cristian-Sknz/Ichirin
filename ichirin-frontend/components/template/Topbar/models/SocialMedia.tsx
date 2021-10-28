import { IconName } from "@fortawesome/fontawesome-common-types";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";


type SocialMediaProps = {
    href: string;
    media: string;
}

export default function SocialMedia({href, media} : SocialMediaProps) {
    return (
    <li className="social-media">
        <a href={href} rel={'external'} target='_blank'>
            <FontAwesomeIcon icon={['fab', media as IconName]}/>
        </a>
    </li>
    );
}