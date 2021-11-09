import MangaData from '../../../lib/types';
import SectionTitle from '../../models/SectionTitle';

import style from './Manga.module.css';

type MangaDescriptionProps = {
  manga: MangaData;
};

function MangaDescription({ manga }: MangaDescriptionProps) {
  return (
    <section className={style.manga_description}>
      <SectionTitle title={'Resumo'} />
      <div className={style.description}>
        {manga.description.map((text, index) => (
            <DescriptionLine
              text={text}
              breakline={index !== manga.description.length - 1}
              key={index}
            />))}
      </div>
    </section>
  );
}
type DescriptionLineProp = {
  text: string;
  breakline?: boolean;
};

function DescriptionLine({ text, breakline }: DescriptionLineProp) {
  return (
    <>
      <p className="description_line">{text}</p>
      {breakline && <br className="description_breakline"/>}
    </>
  );
}

export default MangaDescription;