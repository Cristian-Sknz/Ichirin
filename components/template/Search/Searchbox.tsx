import { useEffect, useState } from 'react';
import mangas from '../../../pages/api/mangas';
import style from './Search.module.css';
import Searchbar from './Searchbar';
import SearchResults from './SearchList/SearchResults';


export default function Searchbox() {
    const [open, setOpen] = useState(true);
    const [results, setResults] = useState([]);
    
    useEffect(() => {
        async function fetchMangas(){
            const mangas = await fetch('/api/mangas')
            setResults(await mangas.json());
        }
        fetchMangas();
    },[])

    return (
        <div className={`${style.searchbox} ${(open) ? style.active : ''}`}>
            <Searchbar onChange={(e) => console.log(e)}/>
            <SearchResults items={results.slice(0, 10)}/>
        </div>
    );
}