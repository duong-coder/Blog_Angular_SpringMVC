import { Account } from './account';

export class WorkExperience{
    id: number;
    companyOrAppName: string;
    titleOrPosition: string;
    description: string;
    dateStart: Date;
    dateEnd: Date;
    accountDTO: Account;
}
