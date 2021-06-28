import { Component, EventEmitter, Input, OnChanges, OnInit, Output } from '@angular/core';
import { Skill } from 'src/app/model/skill';

@Component({
  selector: 'app-skill-edit',
  templateUrl: './skill-edit.component.html',
  styleUrls: ['./skill-edit.component.css']
})
export class SkillEditComponent implements OnInit, OnChanges {
  @Input() skillDTOs: Skill[];
  @Output() openSkillRatingModal = new EventEmitter<Skill>();

  constructor() { }

  ngOnChanges(): void {

  }

  ngOnInit(): void {
  }

  openSkillRating(skill: Skill): void {
    this.openSkillRatingModal.emit(skill);
  }

  addItemForm(obj: any): void {
    const skill = obj.item as Skill;

    const skillClone = new Skill();
    skillClone.id = null;
    skillClone.level = skill.level;
    skillClone.skill = skill.skill + ' copy';
    skillClone.sortIndex = skill.sortIndex;
    skillClone.accountDTO = skill.accountDTO;

    console.log('ADD SKILL: ', obj, skillClone);
    this.skillDTOs.splice(obj.index + 1, 0, skillClone);

    this.updateSortIndex(obj.index, skillClone.sortIndex + 1);
  }
  deleteItemForm(index: number): void {
    console.log('DELETE SKILL: ', index);
    this.skillDTOs.splice(index, 1);
  }

  moveItemForm(indexObj: { oldIndex, newIndex }): void {
    console.log('MOVE SKILL: ', indexObj);
    const temp = this.skillDTOs[indexObj.oldIndex];
    this.skillDTOs[indexObj.oldIndex] = this.skillDTOs[indexObj.newIndex];
    this.skillDTOs[indexObj.newIndex] = temp;

    const newSortIndexTemp = this.skillDTOs[indexObj.newIndex].sortIndex;
    this.skillDTOs[indexObj.newIndex].sortIndex = this.skillDTOs[indexObj.oldIndex].sortIndex;
    this.skillDTOs[indexObj.oldIndex].sortIndex = newSortIndexTemp;

    console.log('SKILLDTOS: ', this.skillDTOs);

  }

  updateSortIndex(indexStart: number, sortIndexStart: number): void {
    console.log('INDEX: ', indexStart, sortIndexStart);

    const skillDTOs = this.skillDTOs;
    let sortIndex = sortIndexStart;
    for (let i = indexStart; i >= 0; i--) {
      console.log('INDEX LOOP: ', i, sortIndex);
      skillDTOs[i].sortIndex = sortIndex;
      sortIndex++;
    }
  }
}
