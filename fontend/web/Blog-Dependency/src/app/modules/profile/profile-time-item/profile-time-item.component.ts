import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { Education } from 'src/app/model/education';
import { WorkExperience } from 'src/app/model/work-experience';

@Component({
  selector: 'app-profile-time-item',
  templateUrl: './profile-time-item.component.html',
  styleUrls: ['./profile-time-item.component.css']
})
export class ProfileTimeItemComponent implements OnInit, OnChanges {
  @Input() itemEducation?: Education;
  @Input() itemWorkExperience?: WorkExperience;

  item: {
    obj: Education | WorkExperience,
    kind: string
  } = {
    obj: undefined,
    kind: 'undefined'
  };

  constructor() { }

  ngOnChanges(): void {
    console.log('ONECHANGE Time Item');
    if (this.itemEducation) {
      this.item = {
        obj: this.itemEducation,
        kind: 'Education'
      };
    } else {
      this.item = {
        obj: this.itemWorkExperience,
        kind: 'WorkExperience'
      };
    }
  }

  ngOnInit(): void {
    console.log('INIT Time Item');
    if (this.itemEducation) {
      this.item = {
        obj: this.itemEducation,
        kind: 'Education'
      };
    } else {
      this.item = {
        obj: this.itemWorkExperience,
        kind: 'WorkExperience'
      };
    }
  }

}
