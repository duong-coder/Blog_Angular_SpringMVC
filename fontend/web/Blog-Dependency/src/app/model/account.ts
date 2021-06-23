import { Education } from './education';
import { Post } from './post';
import { Skill } from './skill';
import { WorkExperience } from './work-experience';

export class Account {
    username: string;
    phonenumber: string;
    password: string;
    dateCreate: Date;
    fullname: string;
    birthday: Date;
    address: string;
    email: string;
    gender: false;
    github: string;
    facebook: string;
    twitter: string;
    role: string;
    hobby: string;
    objective: string;
    addInformation: string;
    references: string;
    awards: string;
    postDTOs: Array<Post>;
    skillDTOs: Array<Skill>;
    educationDTOs: Array<Education>;
    workExperienceDTOs: Array<WorkExperience>;

    constructor() { }
}
