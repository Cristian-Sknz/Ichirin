import styled from 'styled-components';
import RatingStars from '../../models/RatingStar';

export const MangaArticle = styled.article`
  font-family: 'Poppins', sans-serif;
  background: #ecedef;
  background-image: url('/images/bg-triangle-sparkle.png');
  background-size: cover;
  font-size: 14px;
`;

export const MangaArticleContainer = styled.article`
  width: 85%;
  margin: 0 auto;
  max-width: var(--max-width);
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 1rem 0;

  @media screen and (min-width: 769px) {
    align-items: flex-start;
  }
`;

export const MangaTitle = styled.div`
  display: inline-block;
  & h2 {
    font-size: 1.3rem;
    font-weight: 500;
    display: inline-block;
    vertical-align: middle;
  }
`;

export const MangaAgeRating = styled.span`
  padding: 0.35rem 0.4rem;
  color: white;
  background-color: #eb3349;
  font-size: 0.6rem;
  font-weight: 600;
  border-radius: 0.15rem;
  margin-right: 0.4rem;
  display: ${(props) => (isAdult(props) ? 'inline-block' : 'none')};
`;

type isAdultProps = {
  className?: string;
};

function isAdult({ className }: isAdultProps) {
  return className === 'isAdult';
}

export const MangaName = styled.h2`
  font-size: 1.3rem;
  font-weight: 500;
  display: inline-block;
  vertical-align: middle;
`;

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
  max-width: 192px;
  width: 80%;
  background: white;
  padding: 2% 1%;

  @media screen and (min-width: 769px) {
    max-width: 192px;
    width: 30%;
    background: white;
    padding: 2% 1%;
  }
`;

export const MangaStats = styled.div`
  background: rgb(255, 255, 255, 70%);
  margin: 2% 0;
  padding: 0 1rem;
  width: 100%;
  border-radius: 1rem;

  @media screen and (min-width: 769px) {
    padding: 2rem 1rem;
    margin: 0;
    margin-left: 2%;
    width: 80%;
  }
`;

export const RatingStarsStyled = styled(RatingStars)`
  font-size: 1.5rem;
  font-weight: 600;
  text-align: center;
  & svg {
    color: #ffd900;
  }

  @media screen and (min-width: 769px) {
    text-align: left;
  }
`;

export const MangaStatsContainer = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: flex-start;
  padding: 1rem 0;

  @media screen and (min-width: 968px) {
    flex-direction: row;
    padding: 0;
  }
`;

export const ChapterButtons = styled.div`
  margin: 1rem 0;
  text-align: center;

  @media screen and (min-width: 769px) {
    margin: 0;
    text-align: left;
  }
`;

export const ChapterButton = styled.button`
  display: inline-block;
  background: black;
  color: white;
  cursor: pointer;

  padding: 0.7rem 0.6rem;
  border: none;
  border-radius: 0.4rem;
  margin: 0.125rem 0.4rem;
  font-weight: 300;

  @media screen and (min-width: 769px) {
    margin: 0;
    text-align: left;
  }
`;

export const MangaContent = styled.div`
  padding: 0 1rem;

  @media screen and (min-width: 769px) {
    padding: 1rem;
  }
`;

export const MangaStatus = styled.div`
  padding: 0 1rem;

  @media screen and (min-width: 968px) {
    padding: 3rem 1rem;
  }
`;

export const TableContent = styled.table`
  border-collapse: separate;
  border-spacing: 0 0.7rem;
  margin: 1rem 0;
`;

export const TableRow = styled.tr`
  text-align: left;
  & th {
    font-weight: 600;
    padding-right: 1rem;
    max-width: 6.5rem;
    color: #1f1f1f;
  }

  & td {
    padding-right: 1rem;
    font-weight: 400;
    color: #848484;
    max-width: 400px;
  }

  & td a {
    display: inline-block;
    margin: 0.2rem;
  }

  & td a:first-child {
    margin: 0;
    margin-right: 0.2rem;
  }
`;

export const MangaDescriptionContainer = styled.section`
  padding: 2rem 10%;
`;

export const MangaDescription = styled.div`
  margin: 0 auto;
  margin-top: 2rem;
  max-width: var(--max-width);

  & p {
    color: #9d989d;
    font-size: 14px;
    line-height: 1.5;
    word-wrap: break-word;
  }
`;

export const MangaChapters = styled.section`
  padding: 2rem 10%;
  & h3 {
    margin: 1rem;
    text-align: center;
    font-size: 1.1rem;
    color: #9d989d;
  }
`;

export const MangaChapterList = styled.ul`
  margin: 0 auto;
  margin-top: 2rem;
  max-width: var(--max-width);
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
