import styled from 'styled-components';
import RatingStars from '@models/RatingStar';

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
