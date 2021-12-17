import React from 'react';
import SignupForm from './forms/SignupForm';

import { Box, Container } from './style';

const Register: React.FC = () => {
  return (
    <Container>
      <Box className='register'>
        <SignupForm onSubmit={(e) => console.log(e)}/>
      </Box>
    </Container>
  );
};

export default Register;
