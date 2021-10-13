import { IconProp } from '@fortawesome/fontawesome-svg-core';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

type RatingStarsProp = {
  rating: number;
};

export default function RatingStars({ rating }: RatingStarsProp) {
  const stars = [];
  const starLength = Math.floor(rating);

  var halfstar = starLength < rating;
  for (let i = 1; i <= 5; i++) {
    let type = [];
    if (starLength >= i) {
      type = ['fas', 'star'];
    } else if (halfstar) {
      type = ['fas', 'star-half'];
      halfstar = false;
    } else {
      type = ['far', 'star'];
    }

    stars.push(
      <FontAwesomeIcon key={i} color={'yellow'} icon={type as IconProp} />
    );
  }
  return (
    <div className='stars'>
      {stars} {rating}
    </div>
  );
}
