import styled from 'styled-components';
import { FontAwesomeIcon as Icon } from '@fortawesome/react-fontawesome';

export const Commentary = styled.li`
  display: flex;
  margin: 1rem 0;
`;

export const CommentaryContainer = styled.div`
  display: flex;
  flex-direction: column;
  margin: 1rem 0.5rem;
`;

export const CommentaryInfoContainer = styled.div`
  display: flex;
`;

export const CommentaryInfo = styled.div`
  & * {
    :nth-child(1)::before {
      content: "";
      margin: 0;
    }

    ::before {
      content: "•";
      margin: 0 .3rem;
    }
    display: inline;
  }

  p {
    font-weight: 500;
  }
  span {
    color: #666;
    font-size: 14px;
  }
`;

export const CommentaryMessage = styled.p`
  color: #222;
  font-family: Roboto;
  margin: 0.4rem 0;
`;

export const CommentaryInteractions = styled.div`
  display: flex;
  margin: 0.3rem;
  align-items: center;
`;

export const CommentaryButtons = styled.div`
`

export const ReplyButton = styled.button`
  color: #666;
  font-size: 14px;
  background-color: transparent;
  border: none;
  cursor: pointer;
  
  :hover {
    color: #333;
    transform: scale(1.02);
  }
`

export const ThumbIcon = styled(Icon)`
  margin: 0 0.5rem;
  transition: 225ms;
  cursor: pointer;
  :hover {
    transform: scale(1.1);
    transition: 225ms;
  }
`;
