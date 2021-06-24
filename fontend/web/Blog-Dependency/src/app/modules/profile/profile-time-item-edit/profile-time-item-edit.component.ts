import { Component, Input, OnChanges, OnInit, SimpleChanges, ViewContainerRef } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Account } from 'src/app/model/account';
import { Education } from 'src/app/model/education';
import { InputComponent } from 'src/app/model/input-component';
import { KindTimeItemForm } from 'src/app/model/kind-time-item';
import { WorkExperience } from 'src/app/model/work-experience';
import { ComponentService } from 'src/app/service/component.service';
import { FormService } from 'src/app/service/form.service';
import { ProfileTimelineEditComponent } from '../profile-timeline-edit/profile-timeline-edit.component';
import { ProfileTimelineComponent } from '../profile-timeline/profile-timeline.component';

@Component({
  selector: 'app-profile-time-item-edit',
  templateUrl: './profile-time-item-edit.component.html',
  styleUrls: ['./profile-time-item-edit.component.css', '../profile-time-item/profile-time-item.component.css']
})
export class ProfileTimeItemEditComponent implements OnInit, OnChanges {
  @Input() itemEducationForm?: FormGroup;
  @Input() itemWorkExperienceForm?: FormGroup;
  @Input() isEven?: boolean;
  @Input() index?: number;
  @Input() parentComponent: ProfileTimelineEditComponent;

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
  }

  ngOnInit(): void {
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

    // formArray.push(weForm);
    formArray.insert(kindTimeItemForm.index, itemForm);
  }

  deleteItemForm(index: number): void{
    const formArray = this.parentComponent.listFormByKind.formArray;
    formArray.removeAt(index);
  }
}
