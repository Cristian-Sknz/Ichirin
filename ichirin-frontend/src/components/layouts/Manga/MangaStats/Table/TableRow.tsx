import React from 'react';

import { TableRow as StyledTableRow } from '../style';

type TableRowProps = {
  title: string;
  value?: string | string[] | number;
  children?: JSX.Element | JSX.Element[];
};

const TableRow: React.FC<TableRowProps> = ({ title, value, children }) => {
  return (
    <StyledTableRow>
      <th>{title}</th>
      <td>
        {value}
        {children}
      </td>
    </StyledTableRow>
  );
};

export default TableRow;
