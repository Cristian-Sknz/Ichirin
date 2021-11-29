type LinkListProps = {
  name: string;
  href: string;
};

const LinkListItem: React.FC<LinkListProps> = ({ name, href }: LinkListProps) => {
  return (
    <li className='list-item'>
      <a href={href}>{name}</a>
    </li>
  );
};

export default LinkListItem;
