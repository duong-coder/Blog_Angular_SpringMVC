import { Account } from './account';

export class Post {
  id: number;
  heading: string;
  subHeading: string;
  urlImage: string;
  content: string;
  dateCreate: Date;
  accountDTO: Account;

  constructor() {
    this.id = 0;
    this.heading = '';
    this.subHeading = '';
    this.urlImage = '';
    this.content = '';
    this.dateCreate = new Date();
    this.accountDTO = new Account();
  }
}
