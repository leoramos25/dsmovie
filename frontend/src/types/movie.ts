export type Movie = {
    id: string;
    title: string;
    score: number;
    count: number;
    image: string;
}

export type MoviePage = {
    content: Movie[];
    last: boolean;
    totalPages: number;
    totalElements: number;
    size: number;
    first: boolean;
    numberOfElements: number;
    empty: boolean;
}