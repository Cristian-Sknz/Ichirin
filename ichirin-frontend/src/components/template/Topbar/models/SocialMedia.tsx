import { IconName } from '@fortawesome/fontawesome-common-types';
import { FontAwesomeIcon as Icon } from '@fortawesome/react-fontawesome';
import { SocialMedia as StyledSocialMedia, SocialMediaLink } from '../style';

type SocialMediaProps = {
  href: string;
  media: string;
};

const SocialMedia: React.FC<SocialMediaProps> = ({ href, media }) => {
  return (
    <StyledSocialMedia>
      <SocialMediaLink href={href} rel={'noreferrer'} target='_blank'>
        <Icon icon={['fab', media as IconName]} />
      </SocialMediaLink>
    </StyledSocialMedia>
  );
};

export default SocialMedia;