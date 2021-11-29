import { MangaGenre, MangaStatus, MangaType } from '../types/Manga';
import MangaData from '../types';
import mangas from './all_mangas.json';
import genres from './genres.json'
import status from './status.json'
import type from './type.json'

export const Mangas : MangaData[] = mangas as MangaData[];
export const Genres : MangaGenre[] = genres;
export const Status : MangaStatus[] = status;
export const MangaTypes : MangaType[] = type;