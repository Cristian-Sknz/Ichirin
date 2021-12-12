import React from 'react';
import SectionTitle from '../../models/SectionTitle';
import Commentary from './Commentary/Commentary';
import CommentaryForm from './CommentaryForm';
import { CommentaryList, CommentarySection } from './style';

const Comments: React.FC = () => {
  return (
    <CommentarySection>
      {/* filtro de comentarios*/}
      <SectionTitle title={'Comentários'}/>
      <CommentaryForm/>
      <CommentaryList>
        <Commentary></Commentary>
      </CommentaryList>
    </CommentarySection>
  );
};

export default Comments;
