import MangaData from '../../../../lib/types';
import style from '../Search.module.css';
import SearchItem from './SearchItem';

type SearchResultsProps = {
  items: MangaData[];
};

export default function SearchResults({ items }: SearchResultsProps) {
  return (
  <ul className={style.search_results}>
    {items.length != 0 &&
      items.map((item) => <SearchItem item={item}/>)
    }
    {items.length == 0 &&
      <li className={style.empty_result}>
        <h3>Nenhum resultado foi encontrado!</h3>
      </li>
    }
  </ul>
  );
}
