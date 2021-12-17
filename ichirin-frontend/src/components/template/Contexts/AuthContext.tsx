import React, { useEffect, useState } from 'react';
import Router from 'next/router';
import { setCookie, parseCookies } from 'nookies';

import { apiSignIn, SignInData } from '../../../services/auth';
import { DataType, getUserData, User } from '../../../services/user';

export const AuthContext = React.createContext({} as AuthContextType);

type AuthContextType = {
  isAuthenticated: boolean;
  signIn(data: SignInData): Promise<void>;
  user: User | null;
  loading: boolean;
};

export default function AuthProvider({ children }) {
  const [user, setUser] = useState<User | null>(null);
  const [loading, setLoading] = useState<boolean>(true);

  const isAuthenticated = !!user;

  useEffect(() => {
    const { token } = parseCookies();
    if (token) {
      getUserData(DataType.SHORT).then((user) => {
        setUser(user);
        setLoading(false);
      });
      return;
    }
    setTimeout(() => setLoading(false), 1300);
  }, []);

  async function signIn({ email, password }: SignInData) {
    const response = await apiSignIn({ email, password });
    setCookie(undefined, 'token', response.token, {
      maxAge: response.expire,
    });
    Router.push('/');
  }

  return (
    <AuthContext.Provider
      value={{
        isAuthenticated,
        loading,
        user,
        signIn,
      }}
    >
      {children}
    </AuthContext.Provider>
  );
}