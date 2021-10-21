import style from './Loading.module.css';
import LoadingRing from './LoadingRing';

type LoadingProps = {
  loading: boolean;
};

export default function Loading({ loading }: LoadingProps) {


  return (
    <div className={loading ? style.body_loading : `${style.body_loading} ${style.none}`}>
      <img src='/logo.svg' className={style.logo} />
      <LoadingRing/>
    </div>
  );
}
