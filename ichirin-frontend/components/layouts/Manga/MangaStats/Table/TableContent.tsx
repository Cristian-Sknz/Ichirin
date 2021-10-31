import style from '../../Manga.module.css';

type TableContentProps = {
  children?: JSX.Element[] | JSX.Element;
};

function TableContent({children }: TableContentProps) {
  return (
    <table className={style.table_content}>
      <tbody>
        {(children) && children}
      </tbody>
    </table>
  );
}

export default TableContent;
