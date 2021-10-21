import MangaData from '../../../../lib/types';
import style from '../Search.module.css';
import SearchItem from './SearchItem';

type SearchResultsProps = {
  items: MangaData[];
  loading: boolean;
};

export default function SearchResults({ items, loading }: SearchResultsProps) {
  return (
  <ul className={style.search_results}>
    {items.length != 0 &&
      items.map((item) => <SearchItem item={item} key={item.id}/>)
    }
    {items.length == 0 &&
      <li className={style.empty_result}>
        {(!loading) 
          ? <h3>Nenhum resultado foi encontrado!</h3>
          : <h3>Carregando...</h3>
        }
        
      </li>
    }
  </ul>
  );
}
