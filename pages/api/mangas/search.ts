import { NextApiRequest, NextApiResponse } from 'next';
import { Mangas } from '../../../lib/api';
import { removeAccents } from '../../../lib/Util';
import { addURL } from '../mangas';

export default (req: NextApiRequest, res: NextApiResponse) => {
  const { title } = req.query;
  if (!title || title.length == 0) {
    res.status(204).send(null);
    return;
  }

  const itens = Mangas.filter(({ name, alternative_names }) => {
    const regex = new RegExp(toLowerCase(title as string), 'g');
    return (toLowerCase(name).match(regex) ||
      alternative_names.filter((item) => toLowerCase(item).match(regex))
        .length != 0
    );
  }).map(addURL);
  res.status(200).json(itens);
};

function toLowerCase(str): string {
  return removeAccents(str).toLowerCase();
}
