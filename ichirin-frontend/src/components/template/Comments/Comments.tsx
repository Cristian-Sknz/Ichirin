import React from 'react';
import SectionTitle from '../../models/SectionTitle';
import CommentaryForm from './CommentaryForm';
import { CommentarySection } from './style';

const Comments: React.FC = () => {
  return (
    <CommentarySection>
      {/* filtro de comentarios*/}
      <SectionTitle title={'Comentários'}/>
      <CommentaryForm/>
      {/* comentarios*/}
    </CommentarySection>
  );
};

export default Comments;
