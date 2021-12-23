import React from 'react';

import { Ball, BallGridPulse } from './style';

const LoadingRing: React.FC = () => {
  const loadingRings = [];
  for (let i = 0; i < 9; i++) {
    loadingRings.push(<Ball key={i}/>);
  }
  return (
    <BallGridPulse className={'sm'}>
      {loadingRings}
    </BallGridPulse>
  );
};

export default LoadingRing;
