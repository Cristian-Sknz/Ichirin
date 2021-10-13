import style from '../Home.module.css'
import MangaListItem from './MangaListItem';


const image = 'https://ichirinnohanayuriscan.com/wp-content/uploads/2019/05/haru-to-midori-cover1-193x278.jpg';

export function createManga() {
    return {
        id: 0,
        name: 'Manga Title',
        image_url: image,
        description: '',
        type: {
            id: 0,
            name: 'Manga'
        },
        category: {
            id: 0,
            name: 'Manga Category'
        },
        rating: 4.5
    }
}

export type MangaCategory = {
    id: number;
    name: string;
};
  
export type MangaType = {
    id: number;
    name: string;
};

export type MangaData = {
    id: number;
    name: string;
    image_url: string;
    description: string;
    type: MangaType;
    category: MangaCategory;
    rating: number;
}

type MangaListProps = {
    children: MangaListItem[];
}


export default function MangaList({children}) {
    return (<div className={style.manga_list_container}>
        <ul className={style.manga_list}>
            {children}
        </ul>
    </div>);
}