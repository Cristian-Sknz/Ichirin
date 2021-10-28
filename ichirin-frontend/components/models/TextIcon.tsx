import { IconProp } from "@fortawesome/fontawesome-svg-core";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import style from './Models.module.css';

type TextIconProps = {
    text: string;
    icon: IconProp;
}

export default function TextIcon({text, icon}: TextIconProps) {
    return (
    <div className={style.text_icon}>
        <FontAwesomeIcon icon={icon}/>
        <span className='text'>{text}</span>
    </div>
    );
}