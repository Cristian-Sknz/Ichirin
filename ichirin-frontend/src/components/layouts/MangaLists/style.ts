import styled from 'styled-components';

export const MangaLists = styled.section`
  width: 85%;
  margin: 2.5rem auto;
  max-width: var(--max-width);
  font-family: 'Poppins', sans-serif;
`;

export const MangaTypeTitle = styled.h1`
  color: #333;
  font-size: 1.2rem;
  margin: 2rem 0;
  font-weight: 600;
  text-align: center;

  @media screen and (min-width: 968px) {
    text-align: left;
  }
`;

export const MangaListsTitle = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
  margin: 0 auto;
  width: 100%;
  padding: 0.3rem;
  border-bottom: 2px solid rgba(0, 0, 0, 0.185);
  max-width: var(--max-width);

  & h2 {
    display: inline-block;
    margin-left: 1rem;
    font-family: 'Poppins';
    font-weight: 600;
    text-transform: uppercase;
  }
  & .icon {
    display: inline-block;
    background: black;
    max-width: 30px;
    padding: 0.4rem;
  }

  @media screen and (min-width: 968px) {
    flex-direction: row;
  }
`;

export const TitleContainer = styled.div``;

export const FilterList = styled.ul`
  margin: 0.3rem;
  text-align: center;

  @media screen and (min-width: 968px) {
    margin: 0;
  }
`;
export const FilterItem = styled.li`
  :last-child {
    margin: 0;
  }
  & a {
    color: #8b8b8b;
    font-size: 0.9rem;
    :hover {
      color: black;
    }
  }
  & a::after {
    transition: opacity 200ms ease;
    content: '';
    height: 3px;
    width: 100%;
    background-color: black;
    position: absolute;
    top: 100%;
    left: 0;
    opacity: 0;
    top: 25px;
  }
  :hover a::after {
    opacity: 1;
  }

  display: inline-block;
  margin: 0.3rem 0.5rem;
  font-size: 1rem;
  color: #8b8b8b;
  font-weight: 400;
  padding: 0 0.2rem;
  position: relative;
  @media screen and (min-width: 968px) {
    margin: 0 0.5rem;
  }
`;
