import { Account } from './account';

export class Skill {
  id: number;
  skill: string;
  level: number;
  sortIndex: number;
  accountDTO: Account;

  constructor() {
    this.id = 0;
    this.skill = '';
    this.level = 0;
    this.accountDTO = new Account();
  }

  getPercent(): number {
    return this.level * 100 / 5;
  }
}
