import { Component, Input, OnChanges, OnInit, SimpleChanges, ViewContainerRef } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Education } from 'src/app/model/education';
import { InputComponent } from 'src/app/model/input-component';
import { KindTimeItem } from 'src/app/model/kind-time-item';
import { WorkExperience } from 'src/app/model/work-experience';
import { ComponentService } from 'src/app/service/component.service';
import { ProfileTimelineComponent } from '../profile-timeline/profile-timeline.component';

@Component({
  selector: 'app-profile-time-item-edit',
  templateUrl: './profile-time-item-edit.component.html',
  styleUrls: ['./profile-time-item-edit.component.css']
})
export class ProfileTimeItemEditComponent implements OnInit {
  @Input() itemEducation?: Education;
  @Input() itemWorkExperience?: WorkExperience;
  @Input() isEven?: boolean;
  @Input() event: ProfileTimelineComponent;
  @Input() itemTimeForm: FormGroup;

  item: {
    obj: Education | WorkExperience,
    kind: string
  } = {
      obj: undefined,
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

  addEducationItem(value: any): void {
    console.log('Value add time item', value);
    const indexItemExist = this.event.listItem.list.findIndex(item =>{
      return item.id === value.obj.id;
    });
    this.event.listItem.list.splice(indexItemExist, 0, value.obj);
  }

}
