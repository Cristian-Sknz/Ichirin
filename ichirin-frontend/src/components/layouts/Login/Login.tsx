import React, { useContext } from 'react';

import { MessageContainer, Box, Container } from './style';
import Image from 'next/image';
import LoginForm from './forms/LoginForm';
import { AuthContext } from '@ichirin/contexts/auth';

const Login: React.FC = () => {
  const { signIn } = useContext(AuthContext);
  return (
    <Container>
      <Box>
        <MessageContainer>
          <Image src={'/logo.svg'} alt={'Ichirin Logo'} width={260} height={85} />
          <p>
            Leia diversos mangas, manwas, manhwas entre outros!
            <br /><br />
            Scan de fans para fans, sem fins lucrativos!
          </p>
        </MessageContainer>
        <LoginForm onSubmit={(e) => signIn({
          email: e.email,
          password: e.password,
        })}/>
      </Box>
    </Container>
  );
};

export default Login;
