import { Component, EventEmitter, Input, OnChanges, OnInit, Output } from '@angular/core';
import { FormArray, FormControl, FormGroup } from '@angular/forms';
import { ItemSkillFormGroup } from 'src/app/model/kind-tem';
import { Skill } from 'src/app/model/skill';
import { FormService } from 'src/app/service/form.service';

@Component({
  selector: 'app-skill-edit',
  templateUrl: './skill-edit.component.html',
  styleUrls: ['./skill-edit.component.css']
})
export class SkillEditComponent implements OnInit, OnChanges {
  @Input() listSkillForm: FormArray;
  @Output() openSkillRatingModal = new EventEmitter<ItemSkillFormGroup>();

  constructor(
    private formService: FormService
  ) { }

  ngOnChanges(): void {
    console.log('List Skill Form: ', this.listSkillForm);
  }

  ngOnInit(): void {
  }

  openSkillRating(itemSkillFormGroup: ItemSkillFormGroup): void {
    this.openSkillRatingModal.emit(itemSkillFormGroup);
  }

  addItemForm(itemSkillFormGroup: ItemSkillFormGroup): void {
    const skillFormGroup = itemSkillFormGroup.skillFormGroup;

    const skillClone = skillFormGroup.getRawValue();
    const skillFormGroupClone = this.formService.createSkillFormGroup(undefined);
    skillFormGroupClone.patchValue(skillClone);
    skillFormGroupClone.get('skill').setValue(skillFormGroupClone.get('skill').value + ' copy');
    skillFormGroupClone.get('id').setValue(null);

    console.log('ADD SKILL: ', itemSkillFormGroup, skillFormGroupClone);

    this.listSkillForm.insert(itemSkillFormGroup.index + 1, skillFormGroupClone);

    const indexStart = itemSkillFormGroup.index;
    const sortIndexStart = skillFormGroupClone.get('sortIndex').value + 1;
    this.updateSortIndex(indexStart, sortIndexStart);
  }

  deleteItemForm(index: number): void {
    console.log('DELETE SKILL: ', index);
    this.listSkillForm.removeAt(index);
  }

  // moveItemForm(indexObj: { oldIndex, newIndex }): void {
  //   console.log('MOVE SKILL: ', indexObj);
  //   const temp = this.skillDTOs[indexObj.oldIndex];
  //   this.skillDTOs[indexObj.oldIndex] = this.skillDTOs[indexObj.newIndex];
  //   this.skillDTOs[indexObj.newIndex] = temp;

  //   const newSortIndexTemp = this.skillDTOs[indexObj.newIndex].sortIndex;
  //   this.skillDTOs[indexObj.newIndex].sortIndex = this.skillDTOs[indexObj.oldIndex].sortIndex;
  //   this.skillDTOs[indexObj.oldIndex].sortIndex = newSortIndexTemp;

  //   console.log('SKILLDTOS: ', this.skillDTOs);

  // }

  moveItemForm(indexClass: { oldIndex, newIndex }): void {
    console.log('MOVE UP: ', indexClass);

    this.replaceTwoControl(indexClass.oldIndex, indexClass.newIndex);

    console.log('FORM ARRAY: ', this.listSkillForm);

  }

  replaceTwoControl(oldIndex: number, newIndex: number): void {
    const formArray = this.listSkillForm;
    if (newIndex !== oldIndex) {
      const controlName = 'sortIndex';
      const oldItemFormGroup = formArray.at(oldIndex) as FormGroup;
      const sortIndexOldControl = oldItemFormGroup.get(controlName);
      const sortIndexOld = sortIndexOldControl.value;

      const newItemFormGroup = formArray.at(newIndex) as FormGroup;
      const sortIndexNewControl = newItemFormGroup.get(controlName);
      const sortIndexNew = sortIndexNewControl.value;

      sortIndexOldControl.setValue(sortIndexNew, Number);
      sortIndexNewControl.setValue(sortIndexOld, Number);

      // const dataOldFormGroupClone = oldItemFormGroup.getRawValue();
      // const oldFormGroupClone = this.fb.group(dataOldFormGroupClone);
      // const dataNewFormGroupClone = newItemFormGroup.getRawValue();
      // const newFormGroupClone = this.fb.group(dataNewFormGroupClone);

      formArray.insert(oldIndex, newItemFormGroup);
      formArray.removeAt(oldIndex + 1);
      formArray.insert(newIndex, oldItemFormGroup);
      formArray.removeAt(newIndex + 1);
    }
  }

  updateSortIndex(indexStart: number, sortIndexStart: number): void {
    console.log('INDEX: ', indexStart, sortIndexStart);

    let sortIndex = sortIndexStart;
    for (let i = indexStart; i >= 0; i--) {
      console.log('INDEX LOOP: ', i, sortIndex);
      this.listSkillForm.at(i).get('sortIndex').setValue(sortIndex);
      sortIndex++;
    }
  }
  getPercentSkill(levelFormControl: FormControl): number {
    const level = levelFormControl.value;
    if (level) {
      return level * 100 / 5;
    }

    return 0;
  }
}
