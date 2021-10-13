import style from '../Home.module.css'
import FeaturedListItem from './FeaturedListItem';

export default function FeaturedList() {
    return (<div className={style.featured_list_container}>
        <ul className={style.featured_list}>
            <FeaturedListItem/>
            <FeaturedListItem/>
            <FeaturedListItem/>
            <FeaturedListItem/>
            <FeaturedListItem/>
            <FeaturedListItem/>
            <FeaturedListItem/>
            <FeaturedListItem/>
        </ul>
    </div>);
}