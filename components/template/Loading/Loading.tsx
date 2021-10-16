import style from './Loading.module.css';

type LoadingProps = {
  loading: boolean;
};

export default function Loading({ loading }: LoadingProps) {
  const loadingRings = [];
  for (let i = 0; i < 9; i++) {
    loadingRings.push(<div key={i}/>);
  }

  return (
    <div className={loading ? style.body_loading : `${style.body_loading} ${style.none}`}>
      <img src='/logo.svg' className={style.logo} />
      <div className={`${style.la_ball_grid_pulse} ${style.la_sm}`}>
        {loadingRings}
      </div>
    </div>
  );
}
