import Link, { LinkProps } from 'next/link';

export interface AnchorLinkProps extends LinkProps {
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
