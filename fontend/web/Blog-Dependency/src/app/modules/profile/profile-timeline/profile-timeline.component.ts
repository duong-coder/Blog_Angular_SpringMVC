import { Component, Input, OnInit, OnChanges } from '@angular/core';
import { Education } from 'src/app/model/education';
import { WorkExperience } from 'src/app/model/work-experience';

@Component({
  selector: 'app-profile-timeline',
  templateUrl: './profile-timeline.component.html',
  styleUrls: ['./profile-timeline.component.css']
})
export class ProfileTimelineComponent implements OnInit, OnChanges {
  @Input() listItemEducation?: Education[];
  @Input() listItemWorkExperience?: WorkExperience[];

  listItem: {
    kind: string,
    list: Education[] | WorkExperience[];
  } = {
    kind: 'undefined',
    list: [],
  };;

  constructor() { }

  ngOnInit(): void {
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
    console.log("INIT TimeLine", this.listItem);
  }

  ngOnChanges(): void {
    console.log("ONCHANGE TimeLine");
    if (this.listItemEducation) {
      this.listItem = {
        kind: 'Education',
        list: this.listItemEducation
      };
    } else {
      this.listItem = {
        kind: 'WorkExperience',
        list: this.listItemEducation
      };
    }
  }
}
