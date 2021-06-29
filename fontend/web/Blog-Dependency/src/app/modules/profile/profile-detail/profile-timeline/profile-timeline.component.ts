import { Component, Input, OnInit, OnChanges, ViewContainerRef, AfterViewInit } from '@angular/core';
import { FormArray, FormGroup } from '@angular/forms';
import { Education } from 'src/app/model/education';
import { WorkExperience } from 'src/app/model/work-experience';
import { ComponentService } from 'src/app/service/component.service';
import { ProfileTimeItemComponent } from '../profile-time-item/profile-time-item.component';

@Component({
  selector: 'app-profile-timeline',
  templateUrl: './profile-timeline.component.html',
  styleUrls: ['./profile-timeline.component.css']
})
export class ProfileTimelineComponent implements OnInit, OnChanges, AfterViewInit {
  @Input() listItemEducation?: Education[];
  @Input() listItemWorkExperience?: WorkExperience[];
  @Input() isEdit?: boolean;

  listItem: {
    kind: string,
    list: Education[] | WorkExperience[];
  } = {
      kind: 'undefined',
      list: [],
    };

  self = this;

  constructor(
    private componentService: ComponentService,
    private viewContainerRef: ViewContainerRef
  ) { }

  ngOnChanges(): void {
    if (this.listItemEducation) {
      this.listItem = {
        kind: 'Education',
        list: this.listItemEducation
      };
    } else {
      this.listItem = {
        kind: 'WorkExperience',
        list: this.listItemWorkExperience
      };
    }
    console.log('INIT TimeLine', this.listItem);
  }

  ngOnInit(): void {

  }

  ngAfterViewInit(): void {
  }
}
