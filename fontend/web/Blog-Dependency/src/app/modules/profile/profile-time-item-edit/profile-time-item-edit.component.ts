import { Component, Input, OnChanges, OnInit, SimpleChanges, ViewContainerRef } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Education } from 'src/app/model/education';
import { InputComponent } from 'src/app/model/input-component';
import { KindTimeItemForm } from 'src/app/model/kind-time-item';
import { WorkExperience } from 'src/app/model/work-experience';
import { ComponentService } from 'src/app/service/component.service';
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
  @Input() event: ProfileTimelineComponent;

  itemFormGroup: {
    formGroup: FormGroup,
    kind: string
  } = {
      formGroup: undefined,
      kind: 'undefined'
    };
  viewContainerRefProp: ViewContainerRef;

  constructor(
    private componentService: ComponentService,
    private viewContainerRef: ViewContainerRef,
    private fb: FormBuilder) {
  }

  ngOnChanges(): void {
  }

  ngOnInit(): void {
    this.itemFormGroup = {
      kind: 'Education',
      formGroup: this.itemEducationForm
    };
    if (this.itemWorkExperienceForm) {
      this.itemFormGroup = {
        kind: 'WorkExperience',
        formGroup: this.itemWorkExperienceForm
      };
    }
    // this.itemFormGroup.formGroup.get('description').value
    console.log('INIT ITEM EDIT', this.itemFormGroup);
    
  }

  addEducationItem(value: any): void {
    console.log('Value add time item', value);
    const indexItemExist = this.event.listItem.list.findIndex(item => {
      return item.id === value.obj.id;
    });
    this.event.listItem.list.splice(indexItemExist, 0, value.obj);
  }

}
