import style from '../../Manga.module.css';

type TableContentProps = {
  children?: JSX.Element[] | JSX.Element;
};

export default function TableContent({children }: TableContentProps) {
  return (
    <table className={style.table_content}>
      {(children) && children}
    </table>
  );
}
