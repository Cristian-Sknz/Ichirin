import AnchorLink from './AnchorLink';

type LinkListProps = {
  name: string;
  href: string;
};

const AnchorLinkListItem: React.FC<LinkListProps> = ({ name, href }: LinkListProps) => {
  return (
    <li className='list-item'>
      <AnchorLink href={href}>
      {name}
      </AnchorLink>
    </li>
  );
};

export default AnchorLinkListItem;
