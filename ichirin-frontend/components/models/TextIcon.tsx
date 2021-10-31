import { IconProp } from "@fortawesome/fontawesome-svg-core";
import { FontAwesomeIcon as Icon } from "@fortawesome/react-fontawesome";
import style from './Models.module.css';

type TextIconProps = {
    text: string;
    icon: IconProp;
}

function TextIcon({text, icon}: TextIconProps) {
    return (
    <div className={style.text_icon}>
        <Icon icon={icon}/>
        <span className='text'>{text}</span>
    </div>
    );
}

export default TextIcon;