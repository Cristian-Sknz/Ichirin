import React from 'react';

import {
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
  RegisterWith,
  Icon,
} from './style';

const Register: React.FC = () => {
  return (
    <Container>
      <Box className='register'>
        <Form>
          <FormTitle>Crie a sua conta!</FormTitle>

          <FormDescription>
            Já possui uma conta?
            <AnchorLink href={'/signup'}> Logue-se!</AnchorLink>
          </FormDescription>
          <RegisterWith>
            <Icon backgroundColor={'rgb(229 56 65)'} icon={['fab', 'google']}/>
            <Icon backgroundColor={'blue'} icon={['fab', 'facebook']}/>
          </RegisterWith>

          <InputBox>
            <InputContainer>
              <FormInput type={'text'} placeholder={'Nome completo'} />
            </InputContainer>
            <InputContainer>
              <FormInput type={'email'} placeholder={'Digite seu Email'} />
            </InputContainer>
            <InputContainer>
              <FormInput type={'text'} placeholder={'Nickname'} />
            </InputContainer>
            <InputContainer>
              <FormInput type={'password'} placeholder={'Senha'} />
            </InputContainer>
            <InputContainer>
              <input id={'remember'} name={'remember'} type={'checkbox'} />
              <FormLabel htmlFor='remember'>Concordo com a politica de privacidade e termos de uso.</FormLabel>
            </InputContainer>

            <SubmitButton>Registrar-se</SubmitButton>
          </InputBox>
        </Form>
      </Box>
    </Container>
  );
};

export default Register;
