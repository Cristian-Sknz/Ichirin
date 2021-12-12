import React, { useContext } from 'react';
import { FontAwesomeIcon as Icon } from '@fortawesome/react-fontawesome';

import { TopbarItens } from '../../../lib/references';
import AnchorLinkListItem from '../../models/AnchorLinkListItem';
import { PageHeaderContext } from '../Contexts/header';
import SocialMedia from './models/SocialMedia';
import {
  Button,
  Categories,
  LoginContainer,
  SocialMedias,
  TopbarBody,
  TopbarLists,
  Topbar as TopbarStyled,
} from './style';

const Topbar: React.FC = () => {
  const { toggleSidebar } = useContext(PageHeaderContext);
  return (
    <TopbarStyled>
      <TopbarBody>
        <TopbarLists>
          <SocialMedias>
            <SocialMedia href='https://discord.gg/HgmMNPy' media='discord' />
            <SocialMedia href='https://fb.me/ichirinnohanayuri' media='facebook' />
            <SocialMedia
              href='https://m.me/ichirinnohanayuri'
              media='facebook-messenger'
            />
          </SocialMedias>

          <Categories>
            {TopbarItens.map(({ name, link }) => (
              <AnchorLinkListItem key={name} name={name} href={link} />
            ))}
          </Categories>
        </TopbarLists>

        <LoginContainer>
          <Button>Entrar</Button>
          <Button>Cadastrar</Button>
        </LoginContainer>

        <Icon
          className={'menu-btn'}
          icon={['fas', 'bars']}
          onClick={toggleSidebar}
        />
      </TopbarBody>
    </TopbarStyled>
  );
};

export default Topbar;
