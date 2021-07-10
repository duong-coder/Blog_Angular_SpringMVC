import { Component, Input, OnInit, OnChanges, ViewContainerRef, AfterViewInit } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Account } from 'src/app/model/account';
import { Education } from 'src/app/model/education';
import { KindTimeItemForm } from 'src/app/model/kind-tem';
import { WorkExperience } from 'src/app/model/work-experience';
import { ComponentService } from 'src/app/service/component.service';

@Component({
  selector: 'app-profile-timeline-edit',
  templateUrl: './profile-timeline-edit.component.html',
  styleUrls: ['./profile-timeline-edit.component.css']
})
export class ProfileTimelineEditComponent implements OnInit, OnChanges {
  @Input() listEducationForm?: FormArray;
  @Input() listWorkExperienceForm?: FormArray;
  listFormByKind: { kind: string, formArray: FormArray };
  self = this;

  constructor(
  ) { }

  ngOnInit(): void {
  }

  ngOnChanges(): void {
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

