import type { NextApiRequest, NextApiResponse } from 'next';
import MangaData from '../../lib/types';
import { Mangas } from "../../lib/api";

import { convertNameToUrl, removeAccents } from "../../lib/Util";

export default (req: NextApiRequest, res: NextApiResponse) => {
  res.status(200).json(Mangas.map(addURL));
}

export function addURL(manga : MangaData) : MangaData {
  return {...manga, 
    url: `/${removeAccents(manga.type.name)}/${manga.id}`.toLowerCase(),
    urlName: `/${removeAccents(manga.type.name)}/${convertNameToUrl(manga.name)}`.toLowerCase()
  }
}


