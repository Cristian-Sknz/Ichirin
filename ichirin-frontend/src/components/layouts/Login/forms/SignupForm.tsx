import React from 'react';

import * as yup from 'yup';
import { useForm } from 'react-hook-form';
import { yupResolver } from '@hookform/resolvers/yup';

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
  RegisterWith,
  Icon,
  ErrorMessage,
} from '../style';

type RegisterInputs = {
  name: string;
  nickname: string;
  email: string;
  password: string;
  terms: boolean;
};

const schema = yup.object({
  email: yup.string().email().required(),
  name: yup.string().required(),
  nickname: yup.string().min(7).required(),
  password: yup.string().min(8).required(),
  terms: yup.boolean().isTrue(),
});

type FormProps = {
  onSubmit(e: any): void;
};

const SignupForm: React.FC<FormProps> = ({ onSubmit }) => {
  const form = useForm<RegisterInputs>({ resolver: yupResolver(schema) });
  const { register, handleSubmit } = form;
  const { errors } = form.formState;

  return (
    <Form onSubmit={handleSubmit(onSubmit)}>
      <FormTitle>Crie a sua conta!</FormTitle>

      <FormDescription>
        Já possui uma conta?
        <AnchorLink href={'/signup'}> Logue-se!</AnchorLink>
      </FormDescription>
      <RegisterWith>
        <Icon backgroundColor={'rgb(229 56 65)'} icon={['fab', 'google']} />
        <Icon backgroundColor={'blue'} icon={['fab', 'facebook']} />
      </RegisterWith>

      <InputBox>
        <InputContainer>
          <ErrorMessage>{errors.name?.message}</ErrorMessage>
          <FormInput
            type={'text'}
            placeholder={'Nome completo'}
            {...register('name')}
          />
        </InputContainer>
        <InputContainer>
          <ErrorMessage>{errors.email?.message}</ErrorMessage>
          <FormInput
            type={'email'}
            placeholder={'Digite seu Email'}
            {...register('email')}
          />
        </InputContainer>
        <InputContainer>
          <ErrorMessage>{errors.nickname?.message}</ErrorMessage>
          <FormInput
            type={'text'}
            placeholder={'Nickname'}
            {...register('nickname')}
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
          <ErrorMessage>{errors.terms?.message}</ErrorMessage>
          <input
            id={'terms'}
            name={'terms'}
            type={'checkbox'}
            {...register('terms')}
          />
          <FormLabel htmlFor='terms'>
            Concordo com a politica de privacidade e termos de uso.
          </FormLabel>
        </InputContainer>

        <SubmitButton>Registrar-se</SubmitButton>
      </InputBox>
    </Form>
  );
};

export default SignupForm;
