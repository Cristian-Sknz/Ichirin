import React, { useCallback, useEffect, useState, useContext } from 'react';
import { setCookie, parseCookies, destroyCookie } from 'nookies';
import Router from 'next/router';

import type { SignInData, SignUpData } from '@ichirin/services/api/auth/types';

import type { UserCompact } from '@ichirin/services/api/user/types';
import { DataType } from '@ichirin/services/api/types';

import * as auth from '@ichirin/services/api/auth';
import { getUserData } from '@ichirin/services/api/user';
import { LoadingContext } from './loading';

export const AuthContext = React.createContext({} as AuthContextType);

type AuthContextType = {
  isAuthenticated: boolean;
  signIn(data: SignInData): Promise<void>;
  signUp(data: SignUpData): Promise<void>;
  user: UserCompact | null;
};

export default function AuthProvider({ children }) {
  const [user, setUser] = useState<UserCompact | null>(null);
  const { setLoading } = useContext(LoadingContext);
  const isAuthenticated = !!user;

  const fetchUser = useCallback(async () => {
    setUser(await getUserData(DataType.SHORT));
    setLoading(false);
  }, [setLoading]);

  useEffect(() => {
    const { token } = parseCookies();
    if (!token) {
      setTimeout(() => setLoading(false), 1300);
      return;
    }
    fetchUser();
  }, [fetchUser, setLoading]);

  async function signIn({ email, password }: SignInData) {
    const response = await auth.signIn({ email, password });
    setCookie(undefined, 'token', response.token, {
      maxAge: response.expire,
    });
    Router.push('/').then(fetchUser);
  }

  async function signUp(input: SignUpData) {
    const response = await auth.signUp(input);
    await signIn({
      email: input.email,
      password: input.password
    });
  }

  async function logout() {
    destroyCookie(undefined, 'token');
    setUser(null);
    Router.push('/');
  }

  return (
    <AuthContext.Provider
      value={{
        isAuthenticated,
        user,
        signIn,
        signUp
      }}
    >
      {children}
    </AuthContext.Provider>
  );
}
