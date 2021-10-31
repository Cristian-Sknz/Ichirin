import style from './Loading.module.css';
import LoadingRing from './LoadingRing';

type LoadingProps = {
  loading: boolean;
};

function Loading({ loading }: LoadingProps) {
  return (
    <div className={loading ? style.body_loading : `${style.body_loading} ${style.none}`}>
      {/* eslint-disable-next-line @next/next/no-img-element*/}
      <img src='/logo.svg' className={style.logo} alt={'Ichirin Logo'}/>
      <LoadingRing/>
    </div>
  );
}

export default Loading;