import React, { useCallback, useEffect, useState } from 'react';
import Router from 'next/router';
import { setCookie, parseCookies } from 'nookies';

import { apiSignIn, SignInData } from '../../../services/auth';
import { DataType, getUserData, UserCompact } from '../../../services/user';

export const AuthContext = React.createContext({} as AuthContextType);

type AuthContextType = {
  isAuthenticated: boolean;
  signIn(data: SignInData): Promise<void>;
  user: UserCompact | null;
  loading: boolean;
};

export default function AuthProvider({ children }) {
  const [user, setUser] = useState<UserCompact | null>(null);
  const [loading, setLoading] = useState<boolean>(true);
  const isAuthenticated = !!user;

  const fetchUser = useCallback(async () => {
    setUser(await getUserData(DataType.SHORT));
    setLoading(false);
  }, []);

  useEffect(() => {
    const { token } = parseCookies();
    if (!token) {
      setTimeout(() => setLoading(false), 1300);
      return;
    }
    fetchUser();
  }, [fetchUser]);

  async function signIn({ email, password }: SignInData) {
    const response = await apiSignIn({ email, password });
    setCookie(undefined, 'token', response.token, {
      maxAge: response.expire,
    });
    Router.push('/').then(fetchUser);
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
