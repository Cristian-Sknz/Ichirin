import style from './Loading.module.css';

export default function LoadingRing() {
  const loadingRings = [];
  for (let i = 0; i < 9; i++) {
    loadingRings.push(<div key={i} />);
  }
  return (
    <div className={`${style.la_ball_grid_pulse} ${style.la_sm}`}>
      {loadingRings}
    </div>
  );
}
