import React from 'react';

import { TableContent as StyledTableContent } from '../style';

type TableContentProps = {
  children?: JSX.Element[] | JSX.Element;
};

const TableContent: React.FC<TableContentProps> = ({ children }) => {
  return (
    <StyledTableContent>
      <tbody>{children && children}</tbody>
    </StyledTableContent>
  );
};

export default TableContent;
