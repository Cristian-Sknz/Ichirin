import React from 'react';

import { useForm } from 'react-hook-form';
import { yupResolver } from '@hookform/resolvers/yup';
import * as yup from 'yup';

import {
  FormDescription,
  FormTitle,
  InputBox,
  InputContainer,
  Form,
  FormInput,
  FormLabel,
  SubmitButton,
  AnchorLink,
  ErrorMessage,
} from '../style';

type FormProps = {
  onSubmit(e: FormInputs): void;
};

type FormInputs = {
  email: string;
  password: string;
  remember: boolean;
};

const schema = yup.object({
  email: yup.string().email().required(),
  password: yup.string().min(8).required(),
  remember: yup.boolean().default(false).optional(),
});

const LoginForm: React.FC<FormProps> = ({ onSubmit }) => {
  const form = useForm<FormInputs>({ resolver: yupResolver(schema) });
  const { register, handleSubmit } = form;
  const { errors } = form.formState;

  return (
    <Form onSubmit={handleSubmit(onSubmit)}>
      <FormTitle>Entre com sua conta!</FormTitle>
      <FormDescription>
        Ainda não tem uma conta?
        <AnchorLink href={'/signup'}> Registre-se!</AnchorLink>
      </FormDescription>

      <InputBox>
        <InputContainer>
          <ErrorMessage>{errors.email?.message}</ErrorMessage>
          <FormInput
            type={'email'}
            placeholder={'Digite seu Email'}
            {...register('email')}
          />
        </InputContainer>
        <InputContainer>
          <ErrorMessage>{errors.password?.message}</ErrorMessage>
          <FormInput
            type={'password'}
            placeholder={'Senha'}
            {...register('password')}
          />
        </InputContainer>
        <InputContainer>
          <input
            id={'remember'}
            name={'remember'}
            type={'checkbox'}
            {...register('remember')}
          />
          <FormLabel htmlFor='remember'>Lembre de mim</FormLabel>
        </InputContainer>
        <SubmitButton>Entrar</SubmitButton>
      </InputBox>

      <AnchorLink href={'#'}>Esqueceu a senha?</AnchorLink>
    </Form>
  );
};

export default LoginForm;
