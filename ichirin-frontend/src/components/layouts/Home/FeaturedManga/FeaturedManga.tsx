import { FontAwesomeIcon as Icon } from '@fortawesome/react-fontawesome';
import Image from 'next/image';

import MangaData from '../../../../lib/types';
import { textLimiter } from '../../../../lib/Util';
import AnchorLink from '../../../models/AnchorLink';
import RatingStars from '../../../models/RatingStar';
import style from '../Home.module.css';
import {
  FeaturedItem,
  FeaturedItemTitle,
  MangaCategory,
  MangaDescription,
  MangaImageContainer,
  MangaItemInfo,
  MangaName,
  MangaRatingContainer,
} from '../style';

type FeaturedMangaProps = {
  data: MangaData;
};

const FeaturedManga: React.FC<FeaturedMangaProps> = ({ data }) => {
  return (
    <FeaturedItem>
      <MangaImageContainer>
        <AnchorLink href={data.urlName}>
          <Image
            src={data.image_url}
            alt={data.name}
            width={193}
            height={278}
            loading='eager'
          />
        </AnchorLink>
      </MangaImageContainer>

      <MangaItemInfo>
        <FeaturedItemTitle>
          <MangaName>
            <AnchorLink href={data.urlName}>{data.name}</AnchorLink>
          </MangaName>
          <MangaCategory>
            <a href='# '>{data.genre[0]?.name}</a>
          </MangaCategory>
        </FeaturedItemTitle>
        <MangaRatingContainer>
          <RatingStars rating={data.rating} />
        </MangaRatingContainer>
      </MangaItemInfo>

      <MangaDescription>
        {textLimiter(data.description.join(';'), 308)}
      </MangaDescription>

      <AnchorLink href={data.urlName} className={style.readmore}>
        Continuar Lendo <Icon icon={['fas', 'arrow-right']} />
      </AnchorLink>
    </FeaturedItem>
  );
};

export default FeaturedManga;