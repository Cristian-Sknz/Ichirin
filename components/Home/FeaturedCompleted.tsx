import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import style from '../../styles/Home.module.css'
import FeaturedManga from "./FeaturedManga";
import FeaturedList from "./FeaturedList";

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