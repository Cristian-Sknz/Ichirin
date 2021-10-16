import { NextApiRequest, NextApiResponse } from "next";

import MangaData from "../../../lib/types";
import { Mangas } from "../../../lib/api";

import { convertNameToUrl, removeAccents } from "../../../lib/Util";
import { addURL } from "../mangas";

export default (req: NextApiRequest, res: NextApiResponse) => {
    const { id, type } = req.query;
    let items = ((type) ? filterType(type as string, Mangas) : Mangas)
        .filter((manga) => filterId(manga, id))
        .map(addURL);

    if (items[0]) {
      res.status(200).json(JSON.stringify(items[0]));
      return 
    }
    res.status(404).send(null);
};

function filterId(manga : MangaData, id : string | string[]) {
  if (isNaN(parseInt(id as string))) {
    return convertNameToUrl(manga.name).toLowerCase() == (id as string);
  }
  return manga.id == parseInt(id as string)
}

function filterType(typeName : string, mangas : MangaData[]) {
  return mangas.filter(({ type }) => { 
    return removeAccents(type.name).toLowerCase() == typeName.toLowerCase()
  })
}
