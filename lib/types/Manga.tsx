export type MangaData = {
    id: number;
    name: string;
    image_url: string;
    description: string;

    alternative_names: string[];
    isAdult: boolean;
    authors: string[];
    artists: string[];

    status: MangaStatus;
    type: MangaType;
    genre: MangaGenre[];
    releaseYear: number[];
    rating: number;

    url?: string;
}
export type MangaStatus = {
    id: number;
    name: string;
}

export type MangaType = {
    id: number;
    name: string;
};

export type MangaGenre = {
    id: number;
    name: string;
}