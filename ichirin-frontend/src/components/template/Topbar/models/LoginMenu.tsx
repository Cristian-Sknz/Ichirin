import classNames from 'classnames';
import React, { useState } from 'react';
import { UserCompact } from '../../../../services/user';
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
          <DropdownItem href='/logout'>Sair</DropdownItem>
        </DropdownList>
      </Dropdown>
    </LoginContainer>
  );
};

const SignButtons: React.FC = () => {
  return (
    <LoginContainer>
      <Button href={'/signin'}>Entrar</Button>
      <Button href={'/signup'}>Cadastrar</Button>
    </LoginContainer>
  );
};

const LoginMenu: React.FC<LoginMenuProps> = ({ user }) => {
  return user ? <LoggedUser user={user} /> : <SignButtons />;
};

export default LoginMenu;