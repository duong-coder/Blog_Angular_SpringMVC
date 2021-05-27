import { Component, Input, OnInit, OnChanges, ViewContainerRef, AfterViewInit } from '@angular/core';
import { FormArray, FormGroup } from '@angular/forms';
import { Education } from 'src/app/model/education';
import { WorkExperience } from 'src/app/model/work-experience';
import { ComponentService } from 'src/app/service/component.service';
import { ProfileTimeItemComponent } from '../profile-time-item/profile-time-item.component';

@Component({
  selector: 'app-profile-timeline-edit',
  templateUrl: './profile-timeline-edit.component.html',
  styleUrls: ['./profile-timeline-edit.component.css']
})
export class ProfileTimelineEditComponent implements OnInit, OnChanges {
  @Input() listEducationForm?: FormArray;
  @Input() listWorkExperienceForm?: FormArray;
  // @Input() isEdit?: boolean;
  listFormByKind: {kind: string, formArray: FormArray};
  self = this;

  constructor(
    private componentService: ComponentService,
    private viewContainerRef: ViewContainerRef
  ) { }

  ngOnInit(): void {
    // this.listFormByKind = {
    //   kind: 'WorkExperience',
    //   formArray: this.listWorkExperienceForm
    // };
    // if (this.listEducationForm) {
    //   this.listFormByKind = {
    //     kind: 'Education',
    //     formArray: this.listEducationForm
    //   };
    // }
    // console.log('INIT TimeLine Edit', this.listFormByKind);
  }

  ngOnChanges(): void{
    this.listFormByKind = {
      kind: 'WorkExperience',
      formArray: this.listWorkExperienceForm
    };
    if (this.listEducationForm) {
      this.listFormByKind = {
        kind: 'Education',
        formArray: this.listEducationForm
      };
    }
    console.log('CHANGE TimeLine Edit', this.listFormByKind);
  }

  counter(i: number): Array<number> {
    return new Array(i);
}
}

