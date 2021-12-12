import React from 'react';
import {
  InputContainer,
  PublishButton,
  TextArea,
  ToolIcon,
  Tools,
  ToolsContainer,
  UserAvatar,
  UserAvatarContainer,
  UserCommentaryForm,
} from './style';

const CommentaryForm: React.FC = ({children}) => {
  return (
    <UserCommentaryForm>
      <UserAvatarContainer>
        <UserAvatar
          src={'/images/default_avatar.png'}
          width={60}
          height={60}
          alt={'a'}
          layout={'fixed'}
        />
      </UserAvatarContainer>

      <InputContainer>
        <TextArea placeholder={'Escreva um comentário'} contentEditable={'true'} suppressContentEditableWarning={true}>
          {children}
        </TextArea>
        <ToolsContainer>
          <Tools>
            <ToolIcon icon={['fas', 'bold']}/>
            <ToolIcon icon={['fas', 'italic']}/>
            <ToolIcon icon={['fas', 'underline']}/>
          </Tools>
          <PublishButton>Publicar comentário</PublishButton>
        </ToolsContainer>
      </InputContainer>
    </UserCommentaryForm>
  );
};

export default CommentaryForm;