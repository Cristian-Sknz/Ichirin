import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { useCallback, useState } from 'react';
import style from '../Sidebar.module.css';

type SidebarDropdownProps = {
  title: string;
  children: JSX.Element | JSX.Element[] | React.ReactElement[];
  defaultValue?: boolean;
};

export default function SidebarDropdown({title , children, defaultValue }: SidebarDropdownProps) {
  const [active, setActive] = useState<boolean>(defaultValue);

  const handleDropdownClick = useCallback(() => {
    setActive(!active);
  }, [active]);

  return (
    <div className={`${style.sidebar_dropdown} ${active ? style.active : ''}`}>
      <h2 onClick={handleDropdownClick}>
      <FontAwesomeIcon 
          className={style.sidebar_dropdown_icon}
          icon={['fas', 'chevron-up']}/>
        {title} 
      </h2>
      <ul className={`${style.dropdown_list}`} children={children}/>
    </div>
  );
}
