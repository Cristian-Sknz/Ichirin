import React from 'react';
import { IconProp } from '@fortawesome/fontawesome-svg-core';
import { FontAwesomeIcon as Icon } from '@fortawesome/react-fontawesome';

import style from './Models.module.css';

type TextIconProps = {
  text: string;
  icon: IconProp;
};

const TextIcon: React.FC<TextIconProps> = ({ text, icon }) => {
  return (
    <div className={style.text_icon}>
      <Icon icon={icon} />
      <span className='text'>{text}</span>
    </div>
  );
};

export default TextIcon;
