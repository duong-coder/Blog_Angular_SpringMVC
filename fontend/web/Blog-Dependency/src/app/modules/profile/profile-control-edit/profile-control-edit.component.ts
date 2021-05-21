import { Component, EventEmitter, Input, OnInit, Output, ViewContainerRef } from '@angular/core';
import { faMinus, faPlus, faSortDown, faSortUp, IconDefinition } from '@fortawesome/free-solid-svg-icons';
import { Education } from 'src/app/model/education';
import { InputComponent } from 'src/app/model/input-component';
import { KindTimeItemForm } from 'src/app/model/kind-time-item';
import { WorkExperience } from 'src/app/model/work-experience';
import { ComponentService } from 'src/app/service/component.service';

@Component({
  selector: 'app-profile-control-edit',
  templateUrl: './profile-control-edit.component.html',
  styleUrls: ['./profile-control-edit.component.css']
})
export class ProfileControlEditComponent implements OnInit {
  @Output() addEducationEvent = new EventEmitter<KindTimeItemForm>();
  @Input() item: KindTimeItemForm;
  @Input() isEven?: boolean;

  icons: IconDefinition[] = [faSortUp, faSortDown, faPlus, faMinus];

  constructor(
    private componentService: ComponentService,
    private viewContainerRef: ViewContainerRef
  ) { }

  ngOnInit(): void {
  }

  moveUp(): void {

  }

  moveDown(): void {

  }

  add(item: KindTimeItemForm, isEven: boolean): void {
    this.addEducationEvent.emit(item);
  }

  delete(): void {

  }

  // add(item: KindTimeItem, isEven: boolean): void {
  //   let propItemObj = 'itemEducation';
  //   if (item.kind === 'WorkExperience') {
  //     propItemObj = 'itemWorkExperience';
  //   }
  //   const inputs: InputComponent[] = [
  //     { prop: propItemObj, value: item.obj },
  //     { prop: 'isEven', value: !isEven }
  //   ];
  //   this.addEducationEvent.emit(inputs);
  // }
}
