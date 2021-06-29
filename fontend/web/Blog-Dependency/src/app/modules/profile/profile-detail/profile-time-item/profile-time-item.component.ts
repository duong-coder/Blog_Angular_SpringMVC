import { Component, Input, OnChanges, OnInit, SimpleChanges, ViewContainerRef } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Education } from 'src/app/model/education';
import { InputComponent } from 'src/app/model/input-component';
import { KindTimeItemForm } from 'src/app/model/kind-time-item';
import { WorkExperience } from 'src/app/model/work-experience';
import { ComponentService } from 'src/app/service/component.service';
import { ProfileTimelineComponent } from '../profile-timeline/profile-timeline.component';

@Component({
  selector: 'app-profile-time-item',
  templateUrl: './profile-time-item.component.html',
  styleUrls: ['./profile-time-item.component.css']
})
export class ProfileTimeItemComponent implements OnInit, OnChanges {
  @Input() itemEducation?: Education;
  @Input() itemWorkExperience?: WorkExperience;
  @Input() isEven?: boolean;

  item: {
    obj: Education | WorkExperience,
    kind: string
  } = {
      obj: undefined,
      kind: 'undefined'
    };
  constructor(
    private componentService: ComponentService,
    private viewContainerRef: ViewContainerRef,
    private fb: FormBuilder) {
  }

  ngOnChanges(): void {
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

  ngOnInit(): void {

  }
}
