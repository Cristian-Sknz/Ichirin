import styled from 'styled-components';
import Link from '../../models/AnchorLink';

export const LoginContainer = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 1rem 0;
  background-image: url('/images/flower-background.jpg');
  width: 100%;
`;

export const LoginBox = styled.div`
  display: flex;
  width: 90%;
  max-width: 720px;
  min-height: 500px;
  background-color: white;
  border-radius: 1rem;
`;

export const Container = styled.div`
  background-color: #000;
  width: 300px;
  padding: 2rem;
  border-top-left-radius: 1rem;
  border-bottom-left-radius: 1rem;
  display: none;
  & p {
    color: white;
    text-align: center;
  }

  @media screen and (min-width: 540px) {
    display: block;
  }
`;

export const LoginForm = styled.form`
  display: flex;
  flex-direction: column;
  align-items: center;
  flex-grow: 1;
  padding: 2rem;
`;

export const FormTitle = styled.h2`
  color: black;
  text-align: center;
  font-weight: 500;
  font-size: 1.5rem;
`;

export const FormDescription = styled.span`
  color: #777;
  text-align: center;
  margin: 0.5rem 0;
`;

export const InputBox = styled.div`
  margin: 2rem 0;
  width: 100%;
  max-width: 320px;
`;

export const InputContainer = styled.div`
  width: 100%;
  margin: 1rem 0;
`;

export const LoginLabel = styled.label`
  color: #777;
  font-size: 0.9rem;
`;

export const LoginInput = styled.input`
  font-size: 1rem;
  padding: 0.8rem 0.3rem;
  width: 100%;
  border: 1px solid #777;
  border-bottom: 2px solid #777;
  :focus-visible {
    outline: none;
    ::placeholder {
      opacity: 0;
    }
  }
  ::placeholder {
    padding: 0 0.2rem;
    font-size: 1.1rem;
  }
`;

export const SubmitButton = styled.button`
  background-color: #fe9855;
  box-shadow: 0px 0px 1px 0px #8b8b8b;
  color: white;
  border: none;

  width: 100%;
  padding: 0.6rem 0;
  font-size: 1rem;
  font-weight: 500;
  cursor: pointer;
  transition: 180ms;
  :hover {
    background-color: #f5853c;
    box-shadow: 0px 0px 3px 0px #8b8b8b;
    transition: 180ms;
  }
`;

export const AnchorLink = styled(Link)`
  margin: 0 auto;
`