import React from 'react';

import {
  MessageContainer,
  FormDescription,
  FormTitle,
  InputBox,
  InputContainer,
  Box,
  Container,
  Form,
  FormInput,
  FormLabel,
  SubmitButton,
  AnchorLink,
} from './style';
import Image from 'next/image';

const Login: React.FC = () => {
  return (
    <Container>
      <Box>
        <MessageContainer>
          <Image src={'/logo.svg'} alt={'Ichirin Logo'} width={260} height={85} />
          <p>
            Leia diversos mangas, manwas, manhwas entre outros!
            <br /><br />
            Scan de fans para fans, sem fins lucrativos!
          </p>
        </MessageContainer>
        <Form>
          <FormTitle>Entre com sua conta!</FormTitle>
          <FormDescription>
            Ainda não tem uma conta?
            <AnchorLink href={'/signup'}> Registre-se!</AnchorLink>
          </FormDescription>
          <InputBox>
            <InputContainer>
              <FormInput type={'email'} placeholder={'Digite seu Email'} />
            </InputContainer>
            <InputContainer>
              <FormInput type={'password'} placeholder={'Senha'} />
            </InputContainer>
            <InputContainer>
              <input id={'remember'} name={'remember'} type={'checkbox'} />
              <FormLabel htmlFor='remember'>Lembre de mim</FormLabel>
            </InputContainer>
            <SubmitButton>Entrar</SubmitButton>
          </InputBox>
          <AnchorLink href={'#'}>Esqueceu a senha?</AnchorLink>
        </Form>
      </Box>
    </Container>
  );
};

export default Login;
