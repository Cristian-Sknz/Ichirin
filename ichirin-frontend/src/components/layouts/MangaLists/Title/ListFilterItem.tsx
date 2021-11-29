import AnchorLink from '../../../models/AnchorLink';
import { FilterItem } from '../style';

type ListFilterItemProps = {
  name: string;
  href: string;
};

const ListFilterItem: React.FC<ListFilterItemProps> = ({ name, href }) => {
  return (
    <FilterItem>
      <AnchorLink href={href}>{name}</AnchorLink>
    </FilterItem>
  );
};

export default ListFilterItem;
