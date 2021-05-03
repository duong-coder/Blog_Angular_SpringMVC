export class ResponseEnity<T> {
    message: string;
    status: number;
    body: T;
}