import React from 'react';
import Link, { LinkProps } from 'next/link';

export type AnchorLinkProps = LinkProps & {
  className?: string;
  children?: JSX.Element | JSX.Element[] | any;
}

const AnchorLink: React.FC<AnchorLinkProps> = (props: AnchorLinkProps) => {
  return (
    <Link {...props} prefetch={false}>
      <a className={props.className}>{props.children}</a>
    </Link>
  );
};

export default AnchorLink;
