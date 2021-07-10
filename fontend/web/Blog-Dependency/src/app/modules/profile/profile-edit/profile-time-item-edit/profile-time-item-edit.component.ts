import { Component, Input, OnChanges, OnInit, SimpleChanges, ViewContainerRef } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Account } from 'src/app/model/account';
import { Education } from 'src/app/model/education';
import { InputComponent } from 'src/app/model/input-component';
import { KindTimeItemForm } from 'src/app/model/kind-tem';
import { WorkExperience } from 'src/app/model/work-experience';
import { ComponentService } from 'src/app/service/component.service';
import { FormService } from 'src/app/service/form.service';
import { ProfileTimelineEditComponent } from '../profile-timeline-edit/profile-timeline-edit.component';

@Component({
  selector: 'app-profile-time-item-edit',
  templateUrl: './profile-time-item-edit.component.html',
  styleUrls: ['./profile-time-item-edit.component.css', '../../profile-detail/profile-time-item/profile-time-item.component.css']
})
export class ProfileTimeItemEditComponent implements OnInit, OnChanges {
  @Input() itemEducationForm?: FormGroup;
  @Input() itemWorkExperienceForm?: FormGroup;
  @Input() isEven?: boolean;
  @Input() index?: number;
  @Input() parentComponent: ProfileTimelineEditComponent;
  maxIndex: number;
  // isShowControl: boolean;

  itemFormGroup: KindTimeItemForm = {
    formGroup: undefined,
    kind: 'undefined',
    index: -1
  };

  constructor(
    private fb: FormBuilder,
    private formService: FormService) {
  }

  ngOnChanges(): void {
    this.maxIndex = this.parentComponent.listFormByKind.formArray.length;
    this.itemFormGroup = {
      kind: 'Education',
      formGroup: this.itemEducationForm,
      index: this.index
    };
    if (this.itemWorkExperienceForm) {
      this.itemFormGroup = {
        kind: 'WorkExperience',
        formGroup: this.itemWorkExperienceForm,
        index: this.index
      };
    }
    console.log('INIT ITEM EDIT', this.itemFormGroup);
  }

  ngOnInit(): void {

  }

  addItemForm(kindTimeItemForm: KindTimeItemForm): void {
    console.log('Value add time item', kindTimeItemForm);
    const formArray = this.parentComponent.listFormByKind.formArray;

    let itemForm: FormGroup;
    if (kindTimeItemForm.kind === 'WorkExperience') {
      itemForm = this.formService.createWorkExperienceFormGroup(null);

    } else if (kindTimeItemForm.kind === 'Education') {
      itemForm = this.formService.createEducationFormGroup(null);
    }
    const formGroupClone = kindTimeItemForm.formGroup.getRawValue();
    itemForm.patchValue(formGroupClone);

    const idFormControl = itemForm.get('id') as FormControl;
    idFormControl.setValue(null);

    if (kindTimeItemForm.kind === 'WorkExperience') {
      const companyOrAppNameFormControl = itemForm.get('companyOrAppName') as FormControl;
      companyOrAppNameFormControl.setValue(formGroupClone.companyOrAppName + ' copy');
    } else if (kindTimeItemForm.kind === 'Education') {
      const nameFormControl = itemForm.get('name') as FormControl;
      nameFormControl.setValue(formGroupClone.name + ' copy');
    }

    // formArray.push(weForm);
    formArray.insert(kindTimeItemForm.index + 1, itemForm);
    const indexStart = kindTimeItemForm.index;
    const sortIndexStart = itemForm.get('sortIndex').value + 1;
    this.updateSortIndex(indexStart, sortIndexStart);

    console.log('FORM ARRAY: ', formArray.getRawValue());

  }

  deleteItemForm(index: number): void {
    console.log('INDEX DELETE: ' + index);

    const formArray = this.parentComponent.listFormByKind.formArray;
    formArray.removeAt(index);
  }

  moveItemForm(indexClass: { oldIndex, newIndex }): void {
    console.log('MOVE UP: ', indexClass);

    this.replaceTwoControl(indexClass.oldIndex, indexClass.newIndex);

    console.log('FORM ARRAY: ', this.parentComponent.listFormByKind);

  }

  replaceTwoControl(oldIndex: number, newIndex: number): void {
    const formArray = this.parentComponent.listFormByKind.formArray;
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

    const formArray = this.parentComponent.listFormByKind.formArray;
    let sortIndex = sortIndexStart;
    for (let i = indexStart; i >= 0; i--) {
      console.log('INDEX LOOP: ', i, sortIndex);

      const formGroup = formArray.at(i) as FormGroup;
      formGroup.get('sortIndex').setValue(sortIndex, Number);
      sortIndex++;
    }
  }
}
