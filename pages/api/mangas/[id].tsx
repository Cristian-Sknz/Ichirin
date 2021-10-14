import { NextApiRequest, NextApiResponse } from "next";

import MangaData from "../../../lib/types";
import { Mangas } from "../../../lib/api";

import { removeAccents } from "../../../lib/Util";
import { addURL } from "../mangas";

export default (req: NextApiRequest, res: NextApiResponse) => {
    const { id, type } = req.query;
    let items = ((type) ? filterType(type as string, Mangas) : Mangas)
        .filter((manga) => manga.id == parseInt(id as string))
        .map(addURL);

    if (items[0]) {
      res.status(200).json(JSON.stringify(items[0]));
      return 
    }
    res.status(404).send(null);
};

function filterType(typeName : string, mangas : MangaData[]) {
  return mangas.filter(({ type }) => { 
    return removeAccents(type.name).toLowerCase() == typeName.toLowerCase()
  })
}
