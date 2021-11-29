import { FontAwesomeIcon as Icon } from '@fortawesome/react-fontawesome';
import classNames from 'classnames';
import { useCallback, useState } from 'react';
import { Dropdown, DropdownList } from '../style';

type SidebarDropdownProps = {
  title: string;
  children: JSX.Element | JSX.Element[] | React.ReactElement[];
  defaultValue?: boolean;
};

const SidebarDropdown: React.FC<SidebarDropdownProps> = (props) => {
  const [active, setActive] = useState<boolean>(props.defaultValue);
  const sidebar = classNames({
    active: active,
  });

  const handleDropdownClick = useCallback(() => {
    setActive(!active);
  }, [active]);

  return (
    <Dropdown className={sidebar}>
      <h2 onClick={handleDropdownClick}>
        <Icon className={'dropdown_icon'} icon={['fas', 'chevron-up']} />
        {props.title}
      </h2>
      <DropdownList>{props.children}</DropdownList>
    </Dropdown>
  );
};

export default SidebarDropdown;
