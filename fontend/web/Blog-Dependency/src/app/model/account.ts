import { Post } from './post';

export class Account {
    phonenumber: string;
    password: string;
    dateCreate: Date;
    fullname: string;
    birthday: Date;
    address: string;
    academicLevel: string;
    work: string;
    email: string;
    gender: false;
    github: string;
    facebook: string;
    twitter: string;
    postDTOs: Array<Post>;

    constructor() { }
}
