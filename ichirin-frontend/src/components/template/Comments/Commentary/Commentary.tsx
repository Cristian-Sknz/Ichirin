import React from 'react';

import { UserAvatar, UserAvatarContainer } from '../style';
import {
  Commentary as StyledCommentary,
  CommentaryButtons,
  CommentaryContainer,
  CommentaryInfo,
  CommentaryInfoContainer,
  CommentaryInteractions,
  CommentaryMessage,
  ReplyButton,
  ThumbIcon,
} from './style';

const Commentary: React.FC = () => {
  return (
    <StyledCommentary>
      <UserAvatarContainer>
        <UserAvatar
          src={'/images/default_avatar.png'}
          width={60}
          height={60}
          alt={'a'}
          layout={'fixed'}
        />
      </UserAvatarContainer>
      <CommentaryContainer>
        <CommentaryInfoContainer>
          <CommentaryInfo>
            <p>Cristian SknZ</p>
            <span>1 Semana atrás</span>
          </CommentaryInfo>
        </CommentaryInfoContainer>

        <CommentaryMessage>
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Atque, ab! Ducimus
          eligendi officiis consequuntur, ad porro unde, qui nobis ut, illo nesciunt
          sint veniam enim aliquid quod saepe doloribus dicta!
        </CommentaryMessage>

        <CommentaryInteractions>
          <CommentaryButtons>
            <ThumbIcon title={'Gostei'} icon={['far', 'thumbs-up']}/>
            <ThumbIcon title={'Não gostei'} icon={['far', 'thumbs-down']}/>
          </CommentaryButtons>
          <ReplyButton>Responder</ReplyButton>
        </CommentaryInteractions>
        {/*<CommentaryForm>Isso daqui é um comentário de exemplo</CommentaryForm>*/}
      </CommentaryContainer>
    </StyledCommentary>
  );
};

export default Commentary;
