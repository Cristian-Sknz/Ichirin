import { IconProp } from '@fortawesome/fontawesome-svg-core';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { useCallback, useEffect, useState } from 'react';

type RatingStarsProp = {
  className?: string;
  rating: number;
};

export default function RatingStars({ className , rating }: RatingStarsProp) {
  const starTypes : IconProp[] = [['fas','star'], ['fas', 'star-half-alt'], ['far', 'star']];
  const [stars, setStars] = useState<JSX.Element[]>([])
  const starLength = Math.floor(rating);

  const createStar = useCallback((type : IconProp) => {
    return <FontAwesomeIcon color={'yellow'} icon={type as IconProp} />
  }, []);

  useEffect(() => {
    const array = [];
    var halfstar = starLength < rating;
    for (let i =1; i <= 5; i++) {
      if (starLength >= i) {
        array.push(createStar(starTypes[0]));
      } else if (halfstar) {
        array.push(createStar(starTypes[1]));
        halfstar = false;
      } else {
        array.push(createStar(starTypes[0]));
      }
    }
    setStars(array);
  }, [])

  return (
    <div className={(className) ? className : 'rating-stars'}>
      {stars} {rating}
    </div>
  );
}
