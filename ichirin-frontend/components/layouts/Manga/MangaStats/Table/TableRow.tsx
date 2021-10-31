import style from '../../Manga.module.css';

type TableRowProps = {
  title: string;
  value?: string | string[] | number;
  children?: JSX.Element | JSX.Element[];
};

function TableRow({ title, value, children }: TableRowProps) {
  return (
      <tr className={style.table_row}>
        <th>{title}</th>
        <td>{value}{children}</td>
      </tr>
  );
}

export default TableRow;