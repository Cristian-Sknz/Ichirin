import { api } from '@ichirin/services/api';
import { signInFormData, signUpFormData } from './builder';
import { LoginResponse, SignUpResponse, SignInData, SignUpData } from './types';

async function signIn(input: SignInData) {
  const response = await api.post<LoginResponse>('/login', signInFormData(input));
  var { access_token, expires_in } = response.data;
  
  return { token: access_token, expire: expires_in / 1000 };
}

async function signUp(input: SignUpData) {
  const response = await api.post<SignUpResponse>('/signup', signUpFormData(input));
  return response.data;
}

export { signIn, signUp };