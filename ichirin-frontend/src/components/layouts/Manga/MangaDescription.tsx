import MangaData from '../../../lib/types';
import SectionTitle from '../../models/SectionTitle';
import {
  MangaDescriptionContainer,
  MangaDescription as StyledMangaDescription,
  MangaDescriptionParagraph,
} from './style';

type MangaDescriptionProps = {
  manga: MangaData;
};

const MangaDescription: React.FC<MangaDescriptionProps> = ({ manga }) => {
  return (
    <MangaDescriptionContainer>
      <SectionTitle title={'Resumo'} />
      <StyledMangaDescription>
        {manga.description.map((text, index) => (
          <DescriptionLine
            text={text}
            breakline={index !== manga.description.length - 1}
            key={index}
          />
        ))}
      </StyledMangaDescription>
    </MangaDescriptionContainer>
  );
};
type DescriptionLineProp = {
  text: string;
  breakline?: boolean;
};

const DescriptionLine: React.FC<DescriptionLineProp> = ({ text, breakline }) => {
  return (
    <>
      <MangaDescriptionParagraph>{text}</MangaDescriptionParagraph>
      {breakline && <br/>}
    </>
  );
};

export default MangaDescription;
