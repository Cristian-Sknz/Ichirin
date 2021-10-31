import ListFilterItem from './ListFilterItem';

import style from '../MangaLists.module.css';

function ListFilter() {
  return (
    <ul className={style.lists_filter}>
      <li className={style.list_filter_item}>Ordenar por:</li>
      <ListFilterItem name={'Recente'} href={'/'}/>
      <ListFilterItem name={'A-Z'} href={'/'}/>
      <ListFilterItem name={'Avaliação'} href={'/'}/>
      <ListFilterItem name={'Tendência'} href={'/'}/>
      <ListFilterItem name={'Mais Vistos'} href={'/'}/>
      <ListFilterItem name={'Novo'} href={'/'}/>
    </ul>
  );
}

export default ListFilter;
