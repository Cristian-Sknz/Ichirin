import { FontAwesomeIcon as Icon } from '@fortawesome/react-fontawesome';
import { useCallback, useRef } from 'react';

import { TopbarItens } from '../../../lib/references';
import AnchorLinkListItem from '../../models/AnchorLinkListItem';
import LinkListItem from '../../models/LinkListItem';
import Sidebar, { SidebarHandles } from '../Sidebar/Sidebar';
import SocialMedia from './models/SocialMedia';

import { 
  Topbar as TopbarStyled, 
  TopbarBody, 
  TopbarLists, 
  Button, 
  Categories, 
  LoginContainer, 
  SocialMedias,
} from './style';

const Topbar: React.FC = ()  => {
  const sidebarRef = useRef<SidebarHandles>(null);

  const handleSidebarClick = useCallback(() => {
    sidebarRef.current.toggleSidebar();
  }, [sidebarRef]);

  return (
    <>
    <TopbarStyled>
      <TopbarBody>
        <TopbarLists>

          <SocialMedias>
            <SocialMedia href='https://discord.gg/HgmMNPy' media='discord' />
            <SocialMedia href='https://fb.me/ichirinnohanayuri' media='facebook' />
            <SocialMedia href='https://m.me/ichirinnohanayuri' media='facebook-messenger' />
          </SocialMedias>

          <Categories>
            {TopbarItens.map(({name, link}) => 
              (<AnchorLinkListItem key={name}  name={name}href={link}/>))
            }
          </Categories>
        </TopbarLists>

        <LoginContainer>
          <Button>Entrar</Button>
          <Button>Cadastrar</Button>
        </LoginContainer>

        <Icon className={'menu-btn'} icon={['fas', 'bars']} 
          onClick={handleSidebarClick}/>
          
      </TopbarBody>
    </TopbarStyled>
    <Sidebar ref={sidebarRef}/>
    </>
  );
}

export default Topbar;