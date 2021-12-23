import { UserCommentary } from '../user/types'

export type MangaCompact = {
  id: number;
  name: string;
  author: string;
  alternativeNames: string[] | null;
  imageUrl: string;
  summary: string;
  categories: MangaCategory[];
  type: MangaType;
  status: MangaStatus;
}

export type Manga = MangaCompact & {
  information: MangaInformation;
  dates: {
    createdDate: string;
    releaseDate: string;
    lastUpdate: string;
  };
  chapters: MangaChapter[];
  comments: MangaComments[];
}

export type MangaCategory = {
  id: number;
  name: string;
}

export type MangaType = {
  id: number;
  name: MangaTypeEnum;
}

export type MangaStatus = {
  id: number;
  name: MangaStatusEnum;
}

export type MangaInformation = {
  description: MangaDescription;
  type: MangaType;
  status: MangaStatus;
  rating: string;
  alternativeNames: string[];
  authors: string[];
  artists: string[];
}

export type MangaDescription = {
  id: number;
  type: "plain text" | "markdown";
  text: string;
  lastUpdate: string;
}

export type MangaChapter = {
  id: number;
  chapterName: string;
  season: number;
  chapter: number;
}

export type MangaComments = {
  id: number;
  userCommentaries: UserCommentary[];
}

export enum MangaStatusEnum {
  COMPLETED = "Completo",
  IN_RELEASED = "Em Lançamento",
  CANCELED = "Cancelado",
  GAP = "Hiato",
  NOT_YET_AIRED = "Não lançado"
}

export enum MangaTypeEnum {
  MANGA = "Mangá",
  MANHUA = "Manhua",
  MANHWA = "Manhwa",
  WEBTOON = "Webtoon",
  ONESHOT = "One-shot"
}