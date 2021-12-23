import styled, { keyframes } from 'styled-components';
import Loading from './Loading.json';

export const LoadingBody = styled.div`
  position: fixed;
  display: flex;
  align-content: center;
  justify-content: center;
  align-items: center;
  flex-direction: column;

  background: #000;
  width: 100%;
  height: 100%;

  z-index: 6666;
  visibility: visible;
  opacity: 1;

  &.none {
    visibility: hidden;
    opacity: 0;
    transition: visibility 1.6s, opacity 1.5s linear;
  }
`;

export const Logo = styled.img`
  min-width: 250px;
  max-width: 350px;
  margin-bottom: 3rem;
  width: 45vw;
`;

const ballGridPulse = keyframes`
  0% {
    opacity: 1;
    transform: scale(1);
  }
  50% {
    opacity: 0.35;
    transform: scale(0.45);
  }
  100% {
    opacity: 1;
    transform: scale(1);
  }
`;

export const Ball = styled.div`
  width: 8px;
  height: 8px;
  margin: 2px;
  border-radius: 100%;
  animation-name: ${ballGridPulse};
  animation-iteration-count: infinite;

  position: relative;
  box-sizing: border-box;
  margin: 0 auto;

  & {
    display: inline-block;
    float: none;
    background-color: currentColor;
    border: 0 solid currentColor;
  }

  ${() =>
    Loading.map(
      (item, index) =>
        ` :nth-child(${index + 1}) {
            animation-duration: ${item.duration};
            animation-delay: ${item.delay};
          }
         `
    )}
`;

export const BallGridPulse = styled.div`
  position: relative;
  box-sizing: border-box;
  margin: 0 auto;

  display: block;
  font-size: 0;
  color: #fff;

  width: 36px;
  height: 36px;

  &.sm {
    width: calc(18px * 3.5);
    height: calc(18px * 3.5);
  }
  &.sm > ${Ball} {
    width: calc(4px * 3.5);
    height: calc(4px * 3.5);
    margin: calc(1px * 3.5);
  }
`;
