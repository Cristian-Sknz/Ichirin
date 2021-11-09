import { IconProp } from '@fortawesome/fontawesome-svg-core';
import { FontAwesomeIcon as Icon } from '@fortawesome/react-fontawesome';

type RatingStarsProp = {
  className?: string;
  rating: number;
};

function RatingStars({ className , rating }: RatingStarsProp) {
  const starTypes : IconProp[] = [['fas','star'], ['fas', 'star-half-alt'], ['far', 'star']];
  const starLength = Math.floor(rating);

  const createStar = (type : IconProp, key: number) => {
    return <Icon key={key} color={'yellow'} icon={type as IconProp} />
  };

  const formatStars = () => {
    const array = [];
    var halfstar = starLength < rating;
    for (let i =1; i <= 5; i++) {
      if (starLength >= i) {
        array.push(createStar(starTypes[0], i));
      } else if (halfstar) {
        array.push(createStar(starTypes[1], i));
        halfstar = false;
      } else {
        array.push(createStar(starTypes[0], i));
      }
    };
    return array;
  }
  return (
    <div className={(className) ? className : 'rating-stars'}>
      {formatStars()} {rating}
    </div>
  );
}

export default RatingStars;