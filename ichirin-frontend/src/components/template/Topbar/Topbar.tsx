import React, { useContext } from 'react';
import { FontAwesomeIcon as Icon } from '@fortawesome/react-fontawesome';

import { TopbarItens } from '@ichirin/lib/references';
import ListItem from '@ichirin/components/models/LinkListItem';
import { PageHeaderContext } from '@ichirin/contexts/header';
import { AuthContext } from '@ichirin/contexts/auth';

import SocialMedia from './models/SocialMedia';
import {
  Categories,
  SocialMedias,
  TopbarBody,
  TopbarLists,
  Topbar as TopbarStyled,
} from './style';
import LoginMenu from './models/LoginMenu';

const Topbar: React.FC = () => {
  const { toggleSidebar } = useContext(PageHeaderContext);
  const { user } = useContext(AuthContext);
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
              <ListItem key={name} href={link}>
                {name}
              </ListItem>
            ))}
          </Categories>
        </TopbarLists>

        <LoginMenu user={user}/>

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
