import React from 'react';

import AnchorLink from './AnchorLink';

type LinkListProps = {
  href: string;
  useDefault?: boolean;
  children: JSX.Element | JSX.Element[] | string;
};

const LinkListItem: React.FC<LinkListProps> = ({ children, href, useDefault }) => {
  return (
    <li className='list-item'>
      {!useDefault ? (
        <AnchorLink href={href}>{children}</AnchorLink>
      ) : (
        <a href={href}>{children}</a>
      )}
    </li>
  );
};

export default LinkListItem;
