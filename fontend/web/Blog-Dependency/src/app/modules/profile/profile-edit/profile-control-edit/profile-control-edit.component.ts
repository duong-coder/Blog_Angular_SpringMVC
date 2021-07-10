import { Component, EventEmitter, Input, OnInit, Output, ViewContainerRef } from '@angular/core';
import { faMinus, faPlus, faSortDown, faSortUp, IconDefinition } from '@fortawesome/free-solid-svg-icons';
import { Education } from 'src/app/model/education';
import { InputComponent } from 'src/app/model/input-component';
import { KindTimeItemForm } from 'src/app/model/kind-tem';
import { WorkExperience } from 'src/app/model/work-experience';
import { ComponentService } from 'src/app/service/component.service';

@Component({
  selector: 'app-profile-control-edit',
  templateUrl: './profile-control-edit.component.html',
  styleUrls: ['./profile-control-edit.component.css']
})
export class ProfileControlEditComponent implements OnInit {
  @Output() addItemForm = new EventEmitter<any>();
  @Output() deleteItemForm = new EventEmitter<number>();
  @Output() moveUpItemForm = new EventEmitter<{ oldIndex, newIndex }>();
  @Output() moveDownItemForm = new EventEmitter<{ oldIndex, newIndex }>();
  @Input() item: any;
  @Input() maxIndex: number;

  icons: IconDefinition[] = [faSortUp, faSortDown, faPlus, faMinus];

  constructor() { }

  ngOnInit(): void {
  }

  moveUp(): void {
    const currentIndex = this.item.index;
    let newIndex: number = currentIndex;

    if (currentIndex > 0 && currentIndex < this.maxIndex) {
      newIndex = currentIndex - 1;
    }

    const indexObject = {
      oldIndex: currentIndex,
      newIndex
    };

    this.moveUpItemForm.emit(indexObject);
  }

  moveDown(): void {
    const currentIndex = this.item.index;
    let newIndex: number = currentIndex;

    if (currentIndex >= 0 && currentIndex < this.maxIndex - 1) {
      newIndex = currentIndex + 1;
    }

    const indexObject = {
      oldIndex: currentIndex,
      newIndex
    };
    this.moveDownItemForm.emit(indexObject);
  }

  add(): void {
    this.addItemForm.emit(this.item);
  }

  delete(): void {
    this.deleteItemForm.emit(this.item.index);
  }
}
