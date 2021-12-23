import React from 'react';

import AnchorLink from '../../../models/AnchorLink';
import { DropdownItem as StyledDropdownItem } from '../style';

type DropdownItemProps = {
  children: JSX.Element | JSX.Element[] | string;
  href: string;
};

const DropdownItem: React.FC<DropdownItemProps> = ({ children, href }) => {
  return (
    <StyledDropdownItem>
      <AnchorLink href={href}>{children}</AnchorLink>
    </StyledDropdownItem>
  );
};

export default DropdownItem;
