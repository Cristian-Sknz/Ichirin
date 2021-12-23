import { SignInData, SignUpData } from './types';

function signInFormData({email, password} : SignInData): FormData {
  var data = new FormData();
  data.append('username', email);
  data.append('password', password);
  return data;
}

function signUpFormData(input: SignUpData): FormData {
  var data = new FormData();
  data.append('name', input.name)
  data.append('nickname', input.nickname)
  data.append('email', input.email)
  data.append('password', input.password)
  return data;
}

export { signInFormData, signUpFormData };