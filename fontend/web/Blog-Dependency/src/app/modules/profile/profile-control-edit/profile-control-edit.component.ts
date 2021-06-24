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
  @Output() addItemForm = new EventEmitter<KindTimeItemForm>();
  @Output() deleteItemForm = new EventEmitter<number>();
  @Input() item: KindTimeItemForm;

  icons: IconDefinition[] = [faSortUp, faSortDown, faPlus, faMinus];

  constructor() { }

  ngOnInit(): void {
  }

  moveUp(): void {

  }

  moveDown(): void {

  }

  add(item: KindTimeItemForm): void {
    this.addItemForm.emit(item);
  }

  delete(index: number): void {
    this.deleteItemForm.emit(index);
  }
}
