import styled from 'styled-components';
import Image from 'next/image';
import { SectionCSS } from '../../../styles/theme/components';

export const CommentarySection = styled.section`
  ${SectionCSS}
`;

export const UserCommentaryForm = styled.form`
  display: flex;
  margin: 1rem 0;
`;

export const UserAvatarContainer = styled.div`
  margin-top: 0.5rem;
  display: inline-block;
  `

export const UserAvatar = styled(Image)`
  //border: 1px solid #777 !important;
  border-radius: 50%;
  `

export const InputContainer = styled.div`
  display: flex;
  flex-direction: column;
  border: 2px solid #c7c5c5;
  width: 100%;
  border-radius: .3rem;
  margin: 0.5rem;
`;

export const TextArea = styled.div`
  position: relative;
  
  background-color: #f5f5f5;
  font-size: 17px;
  font-family: Roboto;
  
  width: 100%;
  min-height: 80px;
  padding: .3rem;
  line-break: anywhere;
  :focus-visible {
    outline: none;
  }
`;

export const ToolsContainer = styled.div`
  display: flex;
  justify-content: space-between;


  background-color: #eeeeee;
  border-top: 2px solid #c7c5c5;

  width: 100%;
  min-height: 30px;
`

export const Tools = styled.ul`
  display: flex;
`;

export const PublishButton = styled.button`
  background-color: #777;
  color: white;
  border: none;
  padding: .3rem .5rem;

  :hover {
    background-color: #555;
  }
`;