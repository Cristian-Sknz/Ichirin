import AnchorLink from '../../../models/AnchorLink';

import style from '../MangaLists.module.css';

type ListFilterItemProps = {
  name: string;
  href: string;
};

function ListFilterItem({ name, href }: ListFilterItemProps) {
  return (
    <li className={style.list_filter_item}>
      <AnchorLink href={href}>
          {name}
      </AnchorLink>
    </li>
  );
}

export default ListFilterItem;
