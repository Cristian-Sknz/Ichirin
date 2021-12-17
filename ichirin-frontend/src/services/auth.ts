import { api } from './api';

type SuccessData = {
  token_type: string;
  access_token: string;
  expires_in: number;
}

export type SignInData = {
  email: string;
  password: string;
};

async function apiSignIn(data: SignInData) {
  const response = await api.post<SuccessData>('/login', signInData(data));
  var { access_token, expires_in } = response.data;
  
  return { token: access_token, expire: expires_in / 1000 };
}

function signInData({email, password} : SignInData) {
  var data = new FormData();
  data.append('username', email);
  data.append('password', password);
  return data;
}

export { apiSignIn };
