import AnchorLink from './AnchorLink';

type LinkListProps = {
  href: string;
  children: JSX.Element | JSX.Element[] | string;
};

const AnchorLinkListItem: React.FC<LinkListProps> = ({ children, href }: LinkListProps) => {
  return (
    <li className='list-item'>
      <AnchorLink href={href}>
        {children}
      </AnchorLink>
    </li>
  );
};

export default AnchorLinkListItem;
