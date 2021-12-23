import React from 'react';

import Loading from '@template/Loading/Loading';
import NextNProgress from 'nextjs-progressbar';
import { useState } from 'react';

type LoadingContextType = {
  setLoading(bool: boolean): void;
  isLoading: boolean;
};

export const LoadingContext = React.createContext({} as LoadingContextType);

function LoadingProvider({children}) {
  const [isLoading, setLoading] = useState<boolean>(true);
  return (
    <LoadingContext.Provider value={{isLoading, setLoading}}>
      <NextNProgress
        color='#a10160'
        startPosition={0.3}
        stopDelayMs={200}
        height={2}
        showOnShallow={true}
      />
      <Loading loading={isLoading} />
      {children}
    </LoadingContext.Provider>
  );
}

export default LoadingProvider;