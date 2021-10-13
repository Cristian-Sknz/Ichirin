type LinkListProps = {
    name: string;
    href: string;
}

export default function LinkListItem({ name, href } : LinkListProps) {
  return (
    <li className="list-item">
      <a href={href}>{name}</a>
    </li>
  );
}
