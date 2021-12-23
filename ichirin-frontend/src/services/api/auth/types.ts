import { User } from '../user/types';

export type LoginResponse = {
  token_type: string;
  access_token: string;
  expires_in: number;
}

export type SignUpResponse = User;

export type SignInData = {
  email: string;
  password: string;
};

export type SignUpData = {
  email: string;
  name: string;
  nickname: string;
  password: string;
  terms: boolean;
}