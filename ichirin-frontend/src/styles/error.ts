import styled from 'styled-components';

export const ErrorContainer = styled.div`
  display: flex;
  flex-direction: column;
  position: absolute;
  align-items: center;
  justify-content: center;
  text-align: center;
  
  & {
    background-color: #e3e7e6;
    font-family: 'Poppins', sans-serif;
    width: 100%;
    height: 100%;
    padding: 10%;
  }

  & .logo {
    filter: drop-shadow(0px 0px 2px black);
  }

  & .home-btn {
    margin: 1rem 0;
    padding: 1rem;
    border: 2px solid black;
    border-radius: 0.3rem;
    color: white;
    background-color: black;
    transition: 0.5s;
  }

  & .home-btn:hover {
    background-color: white;
    border: 2px solid;
    transition: 0.5s;
    color: black;
  }
`;

export const ErrorTitle = styled.h1`
  font-weight: 600;
  font-size: 1.5rem;
  margin: 1rem 0;
`;

export const ErrorParagraph = styled.p`
  color: #636363;
  max-width: 700px;
  line-height: 1.2;
`;
