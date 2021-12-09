import styled from 'styled-components';
import { Section } from '../../../styles/theme/components';

export const MangaArticle = styled.article`
  font-family: 'Poppins', sans-serif;
  background: #ecedef;
  background-image: url('/images/bg-triangle-sparkle.png');
  background-size: cover;
  font-size: 14px;
`;

export const MangaArticleContainer = styled.section`
  max-width: var(--max-width);
  width: 85%;
  margin: 0 auto;
  padding: 1rem 0;

  display: flex;
  flex-direction: column;
  align-items: center;

  @media screen and (min-width: 769px) {
    align-items: flex-start;
  }
`;

export const MangaTitle = styled.div`
  display: inline-block;
`;

export const MangaName = styled.h2`
  display: inline-block;
  vertical-align: middle;
  font-size: 1.3rem;
  font-weight: 500;
`;

export const MangaAgeRating = styled.span`
  background-color: #eb3349;
  display: ${(props) => (isAdult(props) ? 'inline-block' : 'none')};
  padding: 0.35rem 0.4rem;
  color: white;

  font-size: 0.6rem;
  font-weight: 600;
  border-radius: 0.15rem;
  margin-right: 0.4rem;
`;

type isAdultProps = {
  className?: string;
};

function isAdult({ className }: isAdultProps) {
  return className === 'isAdult';
}

export const MangaContainer = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;

  padding: 1.5rem 0px;

  @media screen and (min-width: 769px) {
    flex-direction: row;
    align-items: flex-start;
    width: 100%;
  }
`;

export const MangaImageContainer = styled.div`
  width: 80%;
  max-width: 192px;
  background: white;
  padding: 2% 1%;

  @media screen and (min-width: 769px) {
    max-width: 192px;
    width: 30%;
    background: white;
    padding: 2% 1%;
  }
`;

export const MangaDescriptionContainer = styled(Section)``;

export const MangaDescription = styled.div`
  margin: 1rem 0.5rem;
`;

export const MangaDescriptionParagraph = styled.p`
  color: #9d989d;
  font-size: 14px;
  line-height: 1.5;
  word-wrap: break-word;
`;

export const MangaChapters = styled(Section)`
  & h3 {
    margin: 1rem;
    text-align: center;
    font-size: 1.1rem;
    color: #9d989d;
  }
`;

export const MangaChapterList = styled.ul`
  margin-top: 2rem;
`;

export const MangaChapterItem = styled.li`
  & a {
    display: flex;
    justify-content: space-between;
    align-items: center;
    font-weight: 500;
  }
  & a small {
    font-size: 0.7rem;
    color: #9d989d;
  }
`;
