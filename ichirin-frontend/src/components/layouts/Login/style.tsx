import { FontAwesomeIcon, FontAwesomeIconProps } from '@fortawesome/react-fontawesome';
import styled from 'styled-components';
import Link from '../../models/AnchorLink';

export const Container = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 1rem 0;
  background-image: url('/images/flower-background.jpg');
  width: 100%;
`;

export const Box = styled.div`
  display: flex;
  width: 90%;
  max-width: 720px;
  min-height: 500px;
  background-color: white;
  border-radius: 1rem;
  &.register {
    max-width: 500px;
  }
`;

export const MessageContainer = styled.div`
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

export const Form = styled.form`
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
  ${Box}.register & {
    margin: .5rem 0;
  }
  margin: 2rem 0;
  width: 100%;
  max-width: 320px;
`;

export const InputContainer = styled.div`
  width: 100%;
  margin: 1rem 0;
`;

export const FormLabel = styled.label`
  color: #777;
  font-size: 0.9rem;
`;

export const ErrorMessage = styled.span`
  display: block;
  color: #ff3535;
  font-size: 14px;
  margin: .2rem;
`

export const FormInput = styled.input`
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

export const RegisterWith = styled.div`
  display: flex;
  max-width: 180px;
  width: 30%;
  justify-content: space-around;
`;

const IconBorder = styled.div`
  background-color: ${(props) => props.color};
  padding: .5rem;
  color: white;
  display: inline-block;
  border-radius: 50%;
  margin: .3rem;
  cursor: pointer;
`;

type IconProp = { backgroundColor: string; } & FontAwesomeIconProps;

export const Icon: React.FC<IconProp> = (props) => {
  return <IconBorder color={props.backgroundColor}>
    <FontAwesomeIcon {...props}/>
  </IconBorder>
}