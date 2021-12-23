import React from 'react';

import AnchorLink from '@models/AnchorLink';
import { FontAwesomeIcon as Icon } from '@fortawesome/react-fontawesome';

import {
  Copyright,
  Footer as StyledFooter,
  FooterContainer,
  FooterLink,
  FooterLinks,
} from './style';

const Footer: React.FC = () => {
  return (
    <StyledFooter>
      <FooterContainer>

        <FooterLinks>
          <FooterLink>
            <AnchorLink href={'/'}>Home</AnchorLink>
          </FooterLink>
          <FooterLink>
            <AnchorLink href={'/sobre'}>Quem Somos</AnchorLink>
          </FooterLink>
          <FooterLink>
            <AnchorLink href={'/faq'}>FAQ</AnchorLink>
          </FooterLink>
          <FooterLink>
            <AnchorLink href={'/privacy'}>Política de Privacidade</AnchorLink>
          </FooterLink>
        </FooterLinks>

        <Copyright>
          <p>© 2021 Ichirin No Hana Yuri.</p>
          <p>
            Criado com <Icon icon={['fas', 'heart']} color={'red'} /> por
            Cristian-SknZ
          </p>
        </Copyright>

      </FooterContainer>
    </StyledFooter>
  );
};

export default Footer;
