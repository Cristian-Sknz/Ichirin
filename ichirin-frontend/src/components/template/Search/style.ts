import styled from 'styled-components';

export const SearchBox = styled.div`
  position: fixed;
  width: 100%;
  height: 100%;
  top: 0;
  left: 0;
  padding: 0 15%;
  z-index: var(--z-searchbox);

  & {
    flex-direction: column;
    align-items: center;
    justify-content: center;
  }

  & {
    background: rgba(0, 0, 0, 0.404);
    display: none;
  }

  &.active {
    display: flex;
  }

  @media screen and (max-width: 425px) {
    padding: 0 5%;
  }
`;

export const SearchForm = styled.form`
  background: rgba(0, 0, 0, 0.815);

  display: flex;
  align-items: center;
  justify-content: center;

  width: 100%;
  max-width: var(--max-width);
  padding: 1rem;
  border-radius: 0.8rem;
`;

export const SearchGroup = styled.div`
  width: 85%;
  display: flex;
  align-items: center;
  & label {
    color: #eb3349;
  }
`;

export const SearchInput = styled.input`
  background: transparent;

  color: white;
  border: none;

  width: 92%;
  padding: 0.2rem;
  margin: 0.3rem;

  font-family: 'Poppins', sans-serif;
  transition: 0.5s;

  :focus {
    font-size: 1rem;
    padding-left: 1rem;
    border-bottom: 2px solid #1e6eff;
    outline: none;
    transition: 0.5s;
  }

  ::placeholder {
    border-bottom: 2px solid #eb3349;
    font-size: 1rem;
    font-weight: 500;
  }

  :focus::placeholder {
    border-bottom: none;
  }
`;

export const CloseButton = styled.button`
  background: #eb3349;
  color: white;
  font-family: 'Poppins';
  font-weight: 500;

  border: none;
  padding: 0.3rem 1rem;
  border-radius: 1rem;
  transition: 0.5s;

  :hover {
    background: #b6293a;
    transform: scale(1.05);
    transition: 0.5s;
  }
`;

export const SearchResults = styled.ul`
  background: rgba(0, 0, 0, 0.336);
  user-select: none;
  overflow: auto;

  width: 100%;
  max-width: var(--max-width);
  max-height: 400px;

  border-radius: 1rem;
  padding: 0.5rem;

  ::-webkit-scrollbar {
    width: 0.6rem;
  }

  ::-webkit-scrollbar-track {
    background: rgba(0, 0, 0, 0.404);
  }

  ::-webkit-scrollbar-thumb {
    background-color: white;
    border: 3px solid rgba(255, 255, 255, 0.4);
    border-radius: 20px;
  }
`;

export const EmptyItem = styled.li`
  color: white;
  text-align: center;
  font-family: 'Poppins', sans-serif;
  font-size: 1.1rem;
  font-weight: 500;
  margin: 1.5rem 0;
  display: none;

  &.active {
    display: list-item;
  }
`;

export const SearchItem = styled.li`
  margin: 0 auto;
  padding: 0.2rem;
  transition: 0.5s;

  :hover {
    background: rgba(255, 255, 255, 0.329);
    border-radius: 1rem;
    transition: 0.5s;
  }

  & a {
    color: white;
    font-family: 'Poppins', sans-serif;

    margin: 1rem 0;

    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;

    cursor: pointer;
  }
`;

export const SearchItemImage = styled.div`
  min-width: 100px;
  min-height: 144px;
  position: relative;
  & img {
    border-radius: 0.5rem;
  }
`;

export const SearchItemInfo = styled.div`
  margin: 0 0.8rem;
  width: 120px;
  min-width: 89px;
  & h3 {
    font-size: 1.2rem;
  }
  & p {
    font-size: 0.9rem;
  }
`;

export const SearchItemDescription = styled.div`
  @media screen and (min-width: 768px) {
    display: block;
    max-width: 600px;
    margin: 0 0.5rem;
    font-size: 0.8rem;
  }
  
  @media screen and (min-width: 968px) {
    font-size: 0.9rem;
  }
  display: none;
`;
