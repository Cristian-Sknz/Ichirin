import classNames from 'classnames';
import LoadingRing from './LoadingRing';
import { LoadingBody, Logo } from './style';

type LoadingProps = {
  loading: boolean;
};

const Loading: React.FC<LoadingProps> = ({ loading }) => {
  return (
    <LoadingBody className={classNames({ none: !loading })}>
      <Logo src='/logo.svg' alt={'Ichirin Logo'}/>
      <LoadingRing />
    </LoadingBody>
  );
};

export default Loading;
