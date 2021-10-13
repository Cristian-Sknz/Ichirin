import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

import FeaturedManga from "./FeaturedManga";
import FeaturedList from "./FeaturedList";

import style from './Home.module.css'

export default function FeaturedCompleted() {
    return (
    <section className={style.feature_completed}>
        <div className={style.section_title}>
            <div className={style.icon}>
                <FontAwesomeIcon icon={['fas', 'star']} color={'white'}/>
            </div>
            <h2>Completos em Destaque</h2>
        </div>

        <div className={style.item_container}>
            <FeaturedManga />
            <FeaturedList />
        </div>

    </section>
    );
}