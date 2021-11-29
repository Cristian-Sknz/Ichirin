import ListFilterItem from './ListFilterItem';

import { FilterItem, FilterList } from '../style';

const ListFilter: React.FC = () => {
  return (
    <FilterList>
      <FilterItem>Ordenar por:</FilterItem>
      <ListFilterItem name={'Recente'} href={'/'} />
      <ListFilterItem name={'A-Z'} href={'/'} />
      <ListFilterItem name={'Avaliação'} href={'/'} />
      <ListFilterItem name={'Tendência'} href={'/'} />
      <ListFilterItem name={'Mais Vistos'} href={'/'} />
      <ListFilterItem name={'Novo'} href={'/'} />
    </FilterList>
  );
};

export default ListFilter;
