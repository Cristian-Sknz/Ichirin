import React, { useState } from 'react';
import classNames from 'classnames';

import { UserCompact } from '@ichirin/services/api/user/types';
import {
  Button,
  Dropdown,
  LoggedUsername,
  LoginContainer,
  UserAvatar,
  DropdownList,
  DropdownItem,
} from '../style';

type LoginMenuProps = {
  user?: UserCompact;
};

type LoggedUserProps = {
  user: UserCompact;
};

const LoggedUser: React.FC<LoggedUserProps> = ({ user }) => {
  const [dropdown, setDropdown] = useState<boolean>(false);
  return (
    <LoginContainer>
      <LoggedUsername>Olá, {user.nickname}</LoggedUsername>
      <UserAvatar
        src={'/images/default_avatar.png'}
        width={40}
        height={40}
        alt={user.nickname}
        onMouseEnter={() => setDropdown(true)}
        onMouseLeave={() => setDropdown(false)}
      />

      <Dropdown className={classNames({ dropdown })}>
        <DropdownList>
          <DropdownItem href='/user/me'>Perfil</DropdownItem>
          <DropdownItem href='/user/me/settings'>Configurações</DropdownItem>
          <DropdownItem href='/auth/logout' useDefault>Sair</DropdownItem>
        </DropdownList>
      </Dropdown>
    </LoginContainer>
  );
};

const SignButtons: React.FC = () => {
  return (
    <LoginContainer>
      <Button href={'/auth/signin'}>Entrar</Button>
      <Button href={'/auth/signup'}>Cadastrar</Button>
    </LoginContainer>
  );
};

const LoginMenu: React.FC<LoginMenuProps> = ({ user }) => {
  return user ? <LoggedUser user={user} /> : <SignButtons />;
};

export default LoginMenu;