import { MangaComments, MangaCompact } from '../mangas/types'

export type UserCompact = {
  id: number;
  name: string;
  nickname: string;
  avatarUrl: string;
  createdDate: string;
  lastLogin: string;
}


export type User = UserCompact & {
  roles: string;
  email: string;
  favorites: MangaCompact[];
  history: MangaCompact[];
  configuration: {
    readingStyle: ReadingStyle;
    imagesPerPage: number;
  }
}

export enum ReadingStyle {
  DEFAULT = "Padrão",
  PAGED = "Paginado",
  CASCADE = "Cascata"
}

export type UserCommentary = UserCompact & {
  id: number;
  createdDate: string;
  content: string;
  manga?: MangaComments;
}