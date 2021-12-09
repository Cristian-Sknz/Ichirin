import Image from 'next/image';
import styled from 'styled-components';
import AnchorLink from '../../models/AnchorLink';

export const FeatureCarrousel = styled.section`
  background-image: url('/images/flower-background.jpg');
  padding: 3rem;
`;

export const CarrouselContainer = styled.div`
  max-width: 93%;
  margin: 0 auto;
`;

export const ImageContainer = styled.div`
  width: 525px;
  height: 270px;
  position: relative;
  margin: 0 auto;
  border: 0.3rem solid white !important;
  border-radius: 0.5rem;
  font-family: 'Poppins', sans-serif;
`;

export const CarrouselImage = styled(Image)`
  background: white;
`;

export const FeatureFinishes = styled.section`
  margin: 4rem 0;
`;

export const ItemContainer = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  margin: 0 auto;
  max-width: var(--max-width);

  @media screen and (min-width: 769px) {
    flex-direction: row;
    align-items: flex-start;
  }

  @media screen and (min-width: 475px) {
    width: 85%;
  }
`;

export const MangaItemInfo = styled.div`
  margin: 0.5rem 0;
`;

export const MangaImageContainer = styled.div`
  overflow: hidden;
  position: relative;
`;

export const MangaName = styled.h2`
  margin: 0.3rem 0;
  & a {
    font-weight: 500;
  }
`;

export const MangaCategory = styled.h3`
  & a {
    color: #656565;

    font-size: 0.8rem;
    font-weight: 500;
  }
`;

export const FeaturedItem = styled.div`
  font-family: 'Poppins';
  width: 100%;
  min-width: 250px;
  max-width: 340px;
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 1rem;

  & ${MangaImageContainer} {
    margin-top: 3rem;
  }

  & ${MangaItemInfo} {
    display: flex;
    justify-content: space-between;
    width: 100%;
    margin: 1rem 0;
  }
`;

export const FeaturedItemTitle = styled.div`
  display: inline-block;
  & ${MangaName} {
    font-weight: 500;
    margin-bottom: 0.4rem;
  }
  & ${MangaCategory} {
    color: #656565;
    font-size: 0.8rem;
    font-weight: 500;
  }
`;

export const MangaDescription = styled.p`
  color: #656565;
  width: 100%;
  font-size: 14px;
  line-height: 2;
`;

export const Readmore = styled(AnchorLink)`
  text-decoration: none;
  display: block;
  margin-top: 0.3rem;
  width: 100%;
  color: #929292;
`;

export const LastMangaUpdates = styled.section`
  margin: 2rem 0;
`;

export const MangaUpdatesContainer = styled.div`
  max-width: var(--max-width);
  margin: 1rem auto;
`;

export const MangaListContainer = styled.div`
  width: 100%;
  font-family: 'Poppins';
`;

export const MangaList = styled.ul`
  display: grid;
  grid-template-columns: repeat(auto-fit, 160px);
  grid-gap: 20px;
  padding: 1rem;
  justify-items: center;
  justify-content: center;
`;

export const MangaListItem = styled.li`
  display: flex;
  flex-direction: column;
  align-items: flex-start;

  & ${MangaImageContainer} a {
    display: block;
  }

  & ${MangaImageContainer} img {
    transition: 0.5s;
    :hover {
      transform: scale(1.1);
      filter: brightness(0.7) contrast(1.2);
      transition: 0.5s;
    }
  }
`;

export const MangaAgeRating = styled.p`
  background: #fa000c91;
  color: white;
  font-weight: 400;
  font-size: 0.8rem;
  padding: 0.3rem;
  border-radius: 0.3rem;

  position: absolute;
  top: 0;
  right: 0;
  z-index: 1;
  display: ${(props) => (isAdult(props) ? 'block' : 'none')};
`;

type isAdultProps = {
  className?: string;
};

function isAdult({ className }: isAdultProps) {
  return className === 'isAdult';
}

export const MangaItemType = styled.p`
  position: absolute;
  bottom: 3px;
  padding: 0.3rem;
  color: white;
  font-weight: 400;
  background: #002efa91;
  font-size: 0.8rem;
`;

export const MangaRatingContainer = styled.div`
  display: inline-block;
  vertical-align: top;
`;
