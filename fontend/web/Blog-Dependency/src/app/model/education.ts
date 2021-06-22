import { Account } from './account';

export class Education{
    id: number;
    name: string;
    description: string;
    gpa: number;
    dateStart: Date;
    dateEnd: Date;
    accountDTO: Account;
}
