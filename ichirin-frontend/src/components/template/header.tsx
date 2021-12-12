import React, { useCallback, useState } from 'react';

type PageHeader = {
  search: boolean;
  toggleSearch(): void;
  sidebar: boolean;
  toggleSidebar(): void;
};

export const PageHeaderContext = React.createContext<PageHeader>({} as PageHeader);

export default function PageHeaderProvider({ children }) {
  const [search, setSearch] = useState<boolean>(false);
  const [sidebar, setSidebar] = useState<boolean>(false);

  const toggleSearch = useCallback(() => {
    if (sidebar && !search) {
      setSidebar(false);
    }
    setSearch(!search);
  }, [search, sidebar]);

  const toggleSidebar = useCallback(() => {
    if (search && !sidebar) {
      setSearch(false);
    }
    setSidebar(!sidebar);
  }, [sidebar, search]);

  return (
    <PageHeaderContext.Provider
      value={{
        search,
        toggleSearch,
        sidebar,
        toggleSidebar,
      }}>
      {children}
    </PageHeaderContext.Provider>
  );
}
