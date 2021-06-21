export class Skill{
    id: number;
    skill: string;
    level: number;

    constructor(id: number, skill: string, level: number){
      this.id = id;
      this.skill = skill;
      this.level = level;
    }

    getPercent(): number{
      return this.level * 100 / 5;
    }
}
