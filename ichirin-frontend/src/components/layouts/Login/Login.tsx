import React from 'react';

import {
  Container,
  FormDescription,
  FormTitle,
  InputBox,
  InputContainer,
  LoginBox,
  LoginContainer,
  LoginForm,
  LoginInput,
  LoginLabel,
  SubmitButton,
  AnchorLink,
} from './style';
import Image from 'next/image';

const Login: React.FC = () => {
  return (
    <LoginContainer>
      <LoginBox>
        <Container>
          <Image src={'/logo.svg'} alt={'Ichirin Logo'} width={260} height={85} />
          <p>
            Leia diversos mangas, manwas, manhwas entre outros!
            <br />
            <br />
            Scan de fans para fans, sem fins lucrativos!
          </p>
        </Container>
        <LoginForm>
          <FormTitle>Entre com sua conta!</FormTitle>
          <FormDescription>
            Ainda não tem uma conta?
            <AnchorLink href={'/signup'}> Registre-se!</AnchorLink>
          </FormDescription>
          <InputBox>
            <InputContainer>
              <LoginInput type={'email'} placeholder={'Digite seu Email'} />
            </InputContainer>
            <InputContainer>
              <LoginInput type={'password'} placeholder={'Senha'} />
            </InputContainer>
            <InputContainer>
              <input id={'remember'} name={'remember'} type={'checkbox'} />
              <LoginLabel htmlFor='remember'>Lembre de mim</LoginLabel>
            </InputContainer>
            <SubmitButton>Entrar</SubmitButton>
          </InputBox>
          <AnchorLink href={'#'}>Esqueceu a senha?</AnchorLink>
        </LoginForm>
      </LoginBox>
    </LoginContainer>
  );
};

export default Login;
